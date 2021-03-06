package com.dyb.platforms.fixfunds.merchant.controller.web;

import com.dyb.platforms.fixfunds.merchant.controller.web.model.MerchantParamModel;
import com.dyb.platforms.fixfunds.services.business.account.entity.Account;
import com.dyb.platforms.fixfunds.services.business.account.entity.em.AccountType;
import com.dyb.platforms.fixfunds.services.business.account.service.IAccountService;
import com.dyb.platforms.fixfunds.services.business.bankaccount.entity.BankAccount;
import com.dyb.platforms.fixfunds.services.business.bankaccount.service.IBankAccountService;
import com.dyb.platforms.fixfunds.services.business.merchant.entity.Merchant;
import com.dyb.platforms.fixfunds.services.business.merchant.service.IMerchantService;
import com.dyb.platforms.fixfunds.services.utils.DybUtils;
import com.dyb.platforms.fixfunds.services.utils.core.QueryParams;
import com.dyb.platforms.fixfunds.services.utils.core.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/1.
 */
@RestController
@RequestMapping(value = "/web/merchant")
public class WebMerchantController extends BaseController {

    public Logger log = Logger.getLogger(WebMerchantController.class);//日志

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private IBankAccountService bankAccountService;

    /**
     * 商户信息链接注册
     * @param account 账户对象
     * @param merchant 商家账户对象
     * @param bankAccount 银行账号信息
     * @return 商家账户对象
     */
    @RequestMapping(value = "/registerMerchantAccount")
    public Object registerMerchantAccount(HttpServletRequest request,HttpServletResponse response,Account account,Merchant merchant,BankAccount bankAccount,String referrerCode,MerchantParamModel merchantParamModel) {
        log.info("商家注册");
        if (account==null)
            return validationResult(1001,"账户信息不能为空");
        if (merchant==null)
            return validationResult(1001,"商家注册时，商家资料不能为空");
        if (bankAccount==null)
            return validationResult(1001,"商家注册时，银行账户信息不能为空");
        if (DybUtils.isEmptyOrNull(referrerCode))
            return validationResult(1001,"商家注册时，推荐人不能为空");
        if (merchantParamModel.getFlag()==1){
            //新版营业执照
            if (DybUtils.isEmptyOrNull(merchantParamModel.getBusinessLicensePhoto1()))
                return validationResult(1001,"营业执照必须上传图片");
        }else {
            //老版营业执照
            if (DybUtils.isEmptyOrNull(merchantParamModel.getBusinessLicensePhoto1()))
                return validationResult(1001,"营业执照必须上传图片");
            if (DybUtils.isEmptyOrNull(merchantParamModel.getBusinessLicensePhoto2()))
                return validationResult(1001,"税务登记证必须上传图片");
        }
        if (DybUtils.isEmptyOrNull(merchantParamModel.getLegalPersonPhoto()))
            return validationResult(1001,"法人身份证必须上传图片");
        if (DybUtils.isEmptyOrNull(merchantParamModel.getRecommendPersonPhoto()))
            return validationResult(1001,"推荐人身份证必须上传图片");
        if (DybUtils.isEmptyOrNull(merchantParamModel.getDonationPhoto()))
            return validationResult(1001,"捐赠承诺书必须上传图片");
        if (DybUtils.isEmptyOrNull(merchantParamModel.getStorePhoto()))
            return validationResult(1001,"店面门头照必须上传图片");
        Map<String,Object> file=new LinkedHashMap<>();
        file.put("flag",merchantParamModel.getFlag());
        file.put("businessLicensePhoto1",merchantParamModel.getBusinessLicensePhoto1());
        file.put("businessLicensePhoto2",merchantParamModel.getBusinessLicensePhoto2());
        file.put("legalPersonPhoto",merchantParamModel.getLegalPersonPhoto());
        file.put("recommendPersonPhoto",merchantParamModel.getRecommendPersonPhoto());
        file.put("donationPhoto",merchantParamModel.getDonationPhoto());
        file.put("storePhoto",merchantParamModel.getStorePhoto());

        merchant.setMerchantType(merchantParamModel.getMerchantType());
        merchant.setIndustryType(merchantParamModel.getIndustryType());
        merchant.setIndustry(merchantParamModel.getIndustry());
        merchant.setScale(merchantParamModel.getScale());
        merchant.setPrincipalSex(merchantParamModel.getPrincipalSex());
        merchant.setCertificateFile(DybUtils.getJsonSerialize(file));
        Account registerMerchantAccount=accountService.registerMerchant(account,merchant,bankAccount,referrerCode);
        if (registerMerchantAccount==null){
            return validationResult(1001,"注册失败");
        }else {
            return result(registerMerchantAccount.getAccountCode());
        }
    }

    /**
     * 获取当前登陆商家地理位置信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getMerchantAddressByCurrent")
    public Object getMerchantAddressByCode(HttpServletRequest request,HttpServletResponse response){
        log.info("获取当前登陆商家地理位置信息");
        Account account=accountService.getAccountByCode(DybUtils.getCurrentAccount(request).getAccountCode(),true);
        if (account==null)
            return validationResult(1001,"找不到此账户信息");
        if (account.getMerchant()==null)
            return validationResult(1001,"找不到此账户的详情信息");
        Map<String,String> result=new HashMap<>();
        result.put("address",account.getMerchant().getMerchantAddress());
        result.put("longitude",account.getMerchant().getLongitude());
        result.put("latitude",account.getMerchant().getLatitude());
        return result(result);
    }

    /**
     * 修改当前登陆商家地理位置
     * @param request
     * @param response
     * @param address 地址
     * @param longitude 经度
     * @param latitude 纬度
     */
    @RequestMapping(value = "/modifyMerchantAddressByCurrent")
    public Object modifyMerchantAddressByCurrent(HttpServletRequest request,HttpServletResponse response,String address,String longitude,String latitude){
        log.info("修改当前登陆商家地理位置");
        if (DybUtils.isEmptyOrNull(address))
            return validationResult(1001,"修改商家地理位置，地址不能为空");
        if (DybUtils.isEmptyOrNull(longitude))
            return validationResult(1001,"修改商家地理位置，经度不能为空");
        if (DybUtils.isEmptyOrNull(latitude))
            return validationResult(1001,"修改商家地理位置，纬度不能为空");
        Account account=accountService.getAccountByCode(DybUtils.getCurrentAccount(request).getAccountCode(),true);
        if (account==null)
            return validationResult(1001,"找不到此账户信息");
        if (account.getMerchant()==null)
            return validationResult(1001,"找不到此账户的详情信息");
        Merchant merchant = merchantService.updateMerchantAddressByCode(account.getMerchant().getMerchantCode(),address,longitude,latitude);
        if (merchant==null)
            return validationResult(1001,"商家地理位置修改失败");
        return result("商家地理位置修改成功");
    }

    /**
     * 获取当前登陆商家信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getMerchantByCurrent")
    public Object getMerchantByCurrent(HttpServletRequest request,HttpServletResponse response){
        log.info("获取当前登陆商家信息");
        Account account=accountService.getAccountByCode(DybUtils.getCurrentAccount(request).getAccountCode(),true);
        Account tjr=accountService.getAccountByCode(account.getReferrerCode(),true);
        if (account==null)
            return validationResult(1001,"找不到此账户信息");
        if (account.getMerchant()==null)
            return validationResult(1001,"找不到此账户的详情信息");
        if (account.getAccountType()!=AccountType.商家)
            return validationResult(1001,"当前登陆用户不是商家用户");

        Map<String,Object> result=new HashMap<>();
        result.put("merchant",account);
        if (tjr.getAccountType()== AccountType.信使){
            result.put("tjrRealName",tjr.getMember().getRealName());
        }else if (tjr.getAccountType()== AccountType.商家){
            result.put("tjrRealName",tjr.getMerchant().getPrincipalName());
        }else if (tjr.getAccountType()== AccountType.服务商){
            result.put("tjrRealName",tjr.getServiceProviders().getServiceProviderName());
        }
        Map<String,Object> certificateFile= (Map<String, Object>) DybUtils.getJsonDeserialize(account.getMerchant().getCertificateFile(),Map.class);
        result.put("certificateFile",certificateFile);
        result.put("tjrPhone",tjr.getAccountPhone());
        result.put("bank",bankAccountService.getBankAccountByDefaultChecked(account.getAccountCode()));
        return result(result);
    }

    /**
     *修改当前登陆商家资料
     * @param request
     * @param response
     * @param merchant 商户详情
     * @param bankAccount 银行卡信息
     */
    @RequestMapping(value = "/modifyMerchantByCurrent")
    public Object modifyMerchantByCurrent(HttpServletRequest request,HttpServletResponse response ,Merchant merchant,BankAccount bankAccount,MerchantParamModel merchantParamModel){
        log.info("修改当前登陆商家资料");
        if (merchant==null)
            return validationResult(1001,"修改商户资料，商户详情信息不能为空");
        if (bankAccount==null)
            return validationResult(1001,"修改商户资料，银行卡信息不能为空");
        Account account=accountService.getAccountByCode(DybUtils.getCurrentAccount(request).getAccountCode(),true);
        if (account==null)
            return validationResult(1001,"找不到此账户信息");
        if (account.getMerchant()==null)
            return validationResult(1001,"找不到此账户的详情信息");
        Merchant updateMerchant = account.getMerchant();
        updateMerchant.setIndustry(merchantParamModel.getIndustry());
        updateMerchant.setScale(merchantParamModel.getScale());
        updateMerchant.setPrincipalSex(merchantParamModel.getPrincipalSex());
        updateMerchant.setMainBusiness(merchant.getMainBusiness());
        updateMerchant.setCountryPhone(merchant.getCountryPhone());
        updateMerchant.setBusinessStartTime(merchant.getBusinessStartTime());
        updateMerchant.setBusinessEndTime(merchant.getBusinessEndTime());
        updateMerchant.setMerchantDescription(merchant.getMerchantDescription());
        updateMerchant.setPrincipalName(merchant.getPrincipalName());
        updateMerchant.setPrincipalJobs(merchant.getPrincipalJobs());
        updateMerchant.setPrincipalIdCard(merchant.getPrincipalIdCard());
        updateMerchant.setPrincipalEmail(merchant.getPrincipalEmail());

        BankAccount updateBankAccount = bankAccountService.getBankAccountByDefaultChecked(account.getAccountCode());
        if (updateBankAccount==null)
            return validationResult(1001,"尚未设置默认银行卡信息");
        updateBankAccount.setBankName(bankAccount.getBankName());
        updateBankAccount.setBankBranch(bankAccount.getBankBranch());
        updateBankAccount.setBankAccountName(bankAccount.getBankAccountName());
        updateBankAccount.setBankNum(bankAccount.getBankNum());

        Account result=accountService.updateMerchant(account,updateMerchant,updateBankAccount);
        if (result==null)
            return validationResult(1001,"商户修改资料失败");
        return result("商户修改资料成功");
    }

    /**
     * 获取商家列表
     * @param request
     * @param pageIndex 当前页
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "/getMerchantPageList")
    public Object getMerchantPageList(HttpServletRequest request,@RequestParam(required=false,defaultValue="0")int pageIndex,@RequestParam(required=false,defaultValue="20")int pageSize){
        log.info("获取商家列表");
        QueryParams queryParams=new QueryParams();
        return result(merchantService.getMerchantPageList(queryParams,pageIndex,pageSize,true));
    }

}
