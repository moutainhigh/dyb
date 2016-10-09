package com.dyb.platforms.fixfunds.merchant.controller.web;

import com.dyb.platforms.fixfunds.services.business.sendaddress.entity.SendAddress;
import com.dyb.platforms.fixfunds.services.business.sendaddress.service.ISendAddressService;
import com.dyb.platforms.fixfunds.services.utils.DybUtils;
import com.dyb.platforms.fixfunds.services.utils.core.QueryParams;
import com.dyb.platforms.fixfunds.services.utils.core.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2015/7/1.
 */
@RestController
@RequestMapping(value = "/web/merchant/sendaddress")
public class WebSenAddressController extends BaseController {

    public Logger log = Logger.getLogger(WebSenAddressController.class);//日志

    @Autowired
    private ISendAddressService sendAddressService;

    /**
     * 寄送地址添加
     * @param request
     * @param response
     * @param sendAddress 寄送地址信息
     */
    @RequestMapping(value = "/addSendAddress")
    public void addSendAddress(HttpServletRequest request,HttpServletResponse response,SendAddress sendAddress) {
        log.info("寄送地址添加");
        QueryParams queryParams=new QueryParams();
        queryParams.addParameter("accountCode", DybUtils.getCurrentAccount(request).getAccountCode());
        List<SendAddress> sendAddressList=sendAddressService.getSendAddressList(queryParams,0,-1,true);
        if (sendAddressList!=null&&sendAddressList.size()>5)
            validationResultJSONP(request,response,1001,"寄送地址已满，请先删除一些不常用的地址");
        if (sendAddress==null)
            validationResultJSONP(request,response,1001,"寄送地址信息不能为空");
        sendAddress.setAccountCode(DybUtils.getCurrentAccount(request).getAccountCode());
        SendAddress temp=sendAddressService.createSendAddress(sendAddress);
        if (temp==null){
            validationResultJSONP(request,response,1001,"添加失败");
        }else {
            resultJSONP(request,response,"添加成功");
        }
    }

    /**
     * 根据code删除寄送地址信息
     * @param request
     * @param response
     * @param sendAddressCode 寄送地址code
     */
    @RequestMapping(value = "/deleteSendAddress")
    public void deleteSendAddress(HttpServletRequest request,HttpServletResponse response,String sendAddressCode){
        log.info("寄送地址删除");
        if (DybUtils.isEmptyOrNull(sendAddressCode))
            validationResultJSONP(request,response,1001,"寄送地址删除时，code不能为空");
        boolean flag=sendAddressService.deleteSendAddress(sendAddressCode);
        if (flag)
            resultJSONP(request,response,"删除成功");
        else
            validationResultJSONP(request, response, 1001, "删除失败");
    }

    /**
     * 根据当前登陆商家获取寄送地址列表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getSendAddressListByCurrent")
    public void getSendAddressPageList(HttpServletRequest request,HttpServletResponse response){
        log.info("根据当前登陆商家获取分页寄送地址列表");
        QueryParams queryParams=new QueryParams();
        queryParams.addParameter("accountCode", DybUtils.getCurrentAccount(request).getAccountCode());
        resultJSONP(request,response,sendAddressService.getSendAddressList(queryParams, 0, -1, true));
    }

}