package com.dyb.platforms.fixfunds.merchant.controller.web;

import com.alibaba.fastjson.JSON;
import com.dyb.platforms.fixfunds.merchant.controller.web.model.MessengerBeanConversionParamModel;
import com.dyb.platforms.fixfunds.services.business.account.entity.Account;
import com.dyb.platforms.fixfunds.services.business.account.entity.em.AccountType;
import com.dyb.platforms.fixfunds.services.business.conversion.service.IConversionService;
import com.dyb.platforms.fixfunds.services.business.conversioninvoicedetails.entity.ConversionInvoiceDetails;
import com.dyb.platforms.fixfunds.services.business.messengerbean.entity.em.MessengerBeanType;
import com.dyb.platforms.fixfunds.services.business.systemparams.entity.SystemParams;
import com.dyb.platforms.fixfunds.services.business.systemparams.service.ISystemParamsService;
import com.dyb.platforms.fixfunds.services.utils.DybUtils;
import com.dyb.platforms.fixfunds.services.utils.core.NameValue;
import com.dyb.platforms.fixfunds.services.utils.core.QueryParams;
import com.dyb.platforms.fixfunds.services.utils.core.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/1.
 */
@RestController
@RequestMapping(value = "/web/merchant/conversion")
public class WebConversionController extends BaseController {

    public Logger log = Logger.getLogger(WebConversionController.class);//日志

    @Autowired
    private IConversionService conversionService;
    @Autowired
    private ISystemParamsService systemParamsService;

    /**
     * 获取当前登陆用户转换表分页
     * @param pageIndex 当前页
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "/getConversionPageList")
    public Object getConversionPageList(HttpServletRequest request,@RequestParam(required=false,defaultValue="0")int pageIndex,@RequestParam(required=false,defaultValue="20")int pageSize){
        log.info("获取当前登陆用户转换表分页");
        QueryParams queryParams=new QueryParams();
        queryParams.addParameter("conversionAccount", DybUtils.getCurrentAccount(request).getAccountCode());
        return result(conversionService.getConversionPageList(queryParams,pageIndex,pageSize,true));
    }

    /**
     * 信使豆转换申请
     * @param request
     * @return
     */
    @RequestMapping(value = "/messengerBeanConversion")
    public Object messengerBeanConversion(HttpServletRequest request){
        log.info("信使豆转换申请");
        String info=request.getParameter("messengerBeanConversionParam");
        if (DybUtils.isEmptyOrNull(info))
            throw new IllegalArgumentException("参数为空");
        MessengerBeanConversionParamModel messengerBeanConversionParamModel= JSON.parseObject(info, MessengerBeanConversionParamModel.class);
        String messengerBeanType=messengerBeanConversionParamModel.getMessengerBeanType();
        String tradePassword=messengerBeanConversionParamModel.getTradePassword();
        Double messengerBean=messengerBeanConversionParamModel.getMessengerBean();
        List<ConversionInvoiceDetails> conversionInvoiceDetailses=messengerBeanConversionParamModel.getConversionInvoiceDetailses();

        if (DybUtils.isEmptyOrNull(messengerBeanType))
            return validationResult(1001,"转换类型不能为空");
        MessengerBeanType conversionType=null;
        for (MessengerBeanType type:MessengerBeanType.values()){
            if (!(type==MessengerBeanType.待提供发票||type!=MessengerBeanType.待缴税))
                continue;
            if (messengerBeanType.equals(type.name())){
                conversionType=type;
            }
        }
        if (conversionType==null)
            return validationResult(1001,"转换类型超出指定范围值");
        if (DybUtils.isEmptyOrNull(tradePassword))
            return validationResult(1001,"二级密码不能为空");
        SystemParams systemParams=null;
        if (conversionType==MessengerBeanType.待提供发票){
            systemParams=systemParamsService.getSystemParamsByKey("conversionTaxInvoice");
        }else if (conversionType==MessengerBeanType.待缴税){
            systemParams=systemParamsService.getSystemParamsByKey("conversionTaxNoInvoice");
        }
        if (systemParams==null)
            return validationResult(1001,"扣税比例尚未设置");
        Double deductions=Double.parseDouble(systemParams.getSystemParamsValue())*messengerBean;
        boolean flag=conversionService.messengerBeanConversion(DybUtils.getCurrentAccount(request).getAccountCode(),conversionType,messengerBean,deductions,tradePassword,conversionInvoiceDetailses);
        if (!flag)
            return validationResult(1001,"信使豆转换申请失败");
        return result("信使豆转换申请成功");
    }

    /**
     * 获取当前登录用户的转换类型
     * @param request
     * @return
     */
    @RequestMapping(value = "/getConversionTypeByCurrent")
    public Object getConversionTypeByCurrent(HttpServletRequest request){
        Account account=DybUtils.getCurrentAccount(request);
        List<NameValue> nameValueList=new ArrayList<>();
        if (account.getAccountType()== AccountType.信使){
            nameValueList.add(NameValue.create(MessengerBeanType.待缴税.toString(),MessengerBeanType.待缴税.toString()));
        }else if (account.getAccountType()==AccountType.商家){
            nameValueList.add(NameValue.create(MessengerBeanType.待提供发票.toString(),MessengerBeanType.待提供发票.toString()));
        }else if (account.getAccountType()==AccountType.服务商){
            nameValueList.add(NameValue.create(MessengerBeanType.待缴税.toString(),MessengerBeanType.待缴税.toString()));
        }
        return result(nameValueList);
    }

}
