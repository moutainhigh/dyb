package com.dyb.platforms.fixfunds.member.controller.client;

import com.dyb.platforms.fixfunds.services.business.account.entity.Account;
import com.dyb.platforms.fixfunds.services.business.account.service.IAccountService;
import com.dyb.platforms.fixfunds.services.business.member.entity.Member;
import com.dyb.platforms.fixfunds.services.utils.DybUtils;
import com.dyb.platforms.fixfunds.services.utils.core.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/7/1.
 */
@RestController
@RequestMapping(value = "/client/member")
public class ClientMemberController extends BaseController {

    public Logger log = Logger.getLogger(ClientMemberController.class);//日志

    @Autowired
    private IAccountService accountService;

    /**
     * 信使信息链接注册
     * @param account 账户对象
     * @param member 信使账户对象
     * @param tjrCode 推荐人的code
     * @return 信使账户对象
     */
    @RequestMapping(value = "/registerMemberAccount")
    public Object registerMemberAccount(Account account,Member member,String tjrCode) {
        log.info("移动端信使注册");
        if (account==null)
            return validationResult(1001,"信使注册时，账户信息不能为空");
        if (member==null)
            return validationResult(1001,"信使注册时，信使资料不能为空");
        if (DybUtils.isEmptyOrNull(tjrCode))
            return validationResult(1001,"信使注册时，推荐人不能为空");
        Account registerMemberAccount=accountService.registerMember(account,member,tjrCode);
        if (registerMemberAccount==null){
            return validationResult(1001,"注册失败");
        }else {
            return result("注册成功");
        }
    }

}
