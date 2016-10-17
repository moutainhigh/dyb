/**
 * 2016/9/26 9:13:00 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.entity 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.account.entity;

import com.dyb.platforms.fixfunds.services.business.account.entity.em.AccountStatus;
import com.dyb.platforms.fixfunds.services.business.account.entity.em.AccountType;
import com.dyb.platforms.fixfunds.services.business.member.entity.Member;
import com.dyb.platforms.fixfunds.services.business.merchant.entity.Merchant;
import com.dyb.platforms.fixfunds.services.business.serviceproviders.entity.ServiceProviders;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 账号信息
 * Created by lenovo on 2016/09/26.
 */
public class Account implements java.io.Serializable {

    // 序列化版本
    private static final long serialVersionUID = -7169736967035447296L;

    // 账号code [主键]
    private String accountCode;
    // 账户名
    private String accountName;
    // 账户密码
    private String password;
    // 二级密码
    private String tradePassword;
    // 绑定手机号
    private String accountPhone;
    // 账户状态
    private AccountStatus accountStatus;
    // 账户类别
    private AccountType accountType;
    // 账户详情信息外键
    private String accountForeignKey;
    // 推荐人code
    private String referrerCode;
    // 推荐位置（格式：推荐人code+自己的coe）
    private String referrerLocation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 注册时间
    private Date registrationTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 申请注册时间
    private Date applyRegistrationTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 创建时间
    private Date createTime;
    //二维码路径
    private String qrcode;
    // 头像
    private String headPortrait;

    //商户详情
    private Merchant merchant;
    //信使详情
    private Member member;
    //服务商详情
    private ServiceProviders serviceProviders;

    /** 
     * 获取账号code [主键]
     * 
     * @return 账号code
     */
    public String getAccountCode() {
        return accountCode;
    }

    /** 
     * 设置账号code [主键]
     * 
     * @param accountCode 账号code
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /** 
     * 获取账户名
     * 
     * @return 账户名
     */
    public String getAccountName() {
        return accountName;
    }

    /** 
     * 设置账户名
     * 
     * @param accountName 账户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /** 
     * 获取账户密码
     * 
     * @return 账户密码
     */
    public String getPassword() {
        return password;
    }

    /** 
     * 设置账户密码
     * 
     * @param password 账户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * 获取二级密码
     * 
     * @return 二级密码
     */
    public String getTradePassword() {
        return tradePassword;
    }

    /** 
     * 设置二级密码
     * 
     * @param tradePassword 二级密码
     */
    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    /** 
     * 获取绑定手机号
     * 
     * @return 绑定手机号
     */
    public String getAccountPhone() {
        return accountPhone;
    }

    /** 
     * 设置绑定手机号
     * 
     * @param accountPhone 绑定手机号
     */
    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    /** 
     * 获取账户状态
     * 
     * @return 账户状态
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /** 
     * 设置账户状态
     * 
     * @param accountStatus 账户状态
     */
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    /** 
     * 获取账户类别
     * 
     * @return 账户类别
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /** 
     * 设置账户类别
     * 
     * @param accountType 账户类别
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /** 
     * 获取账户详情信息外键
     * 
     * @return 账户详情信息外键
     */
    public String getAccountForeignKey() {
        return accountForeignKey;
    }

    /** 
     * 设置账户详情信息外键
     * 
     * @param accountForeignKey 账户详情信息外键
     */
    public void setAccountForeignKey(String accountForeignKey) {
        this.accountForeignKey = accountForeignKey;
    }

    /** 
     * 获取推荐人code
     * 
     * @return 推荐人code
     */
    public String getReferrerCode() {
        return referrerCode;
    }

    /** 
     * 设置推荐人code
     * 
     * @param referrerCode 推荐人code
     */
    public void setReferrerCode(String referrerCode) {
        this.referrerCode = referrerCode;
    }

    /** 
     * 获取推荐位置（格式：推荐人code+自己的coe）
     * 
     * @return 推荐位置（格式：推荐人code+自己的coe）
     */
    public String getReferrerLocation() {
        return referrerLocation;
    }

    /** 
     * 设置推荐位置（格式：推荐人code+自己的coe）
     * 
     * @param referrerLocation 推荐位置（格式：推荐人code+自己的coe）
     */
    public void setReferrerLocation(String referrerLocation) {
        this.referrerLocation = referrerLocation;
    }

    /** 
     * 获取注册时间
     * 
     * @return 注册时间
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /** 
     * 设置注册时间
     * 
     * @param registrationTime 注册时间
     */
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    /** 
     * 获取申请注册时间
     * 
     * @return 申请注册时间
     */
    public Date getApplyRegistrationTime() {
        return applyRegistrationTime;
    }

    /** 
     * 设置申请注册时间
     * 
     * @param applyRegistrationTime 申请注册时间
     */
    public void setApplyRegistrationTime(Date applyRegistrationTime) {
        this.applyRegistrationTime = applyRegistrationTime;
    }

    /** 
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置创建时间
     * 
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取二维码
     *
     * @return 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置二维码
     *
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ServiceProviders getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(ServiceProviders serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    /**
     * 获取头像
     *
     * @return 头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 设置头像
     *
     * @param headPortrait 头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
