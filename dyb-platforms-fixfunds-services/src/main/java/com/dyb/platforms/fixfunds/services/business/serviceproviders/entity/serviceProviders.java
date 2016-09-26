/**
 * 2016/9/26 11:27:47 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.entity 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.serviceproviders.entity;

import com.dyb.platforms.fixfunds.services.business.merchant.entity.em.Industry;
import com.dyb.platforms.fixfunds.services.business.merchant.entity.em.Sex;

import java.util.Date;

/**
 * 服务商信息
 * Created by lenovo on 2016/09/26.
 */
public class ServiceProviders implements java.io.Serializable {

    // 序列化版本
    private static final long serialVersionUID = -5533795592158006272L;

    // 服务商编号code [主键]
    private String serviceProviderCode;
    // 姓名
    private String serviceProviderName;
    // 所属行业
    private Industry industry;
    // 性别
    private Sex sex;
    // 出生日期
    private Date birthday;
    // 邮箱地址
    private String email;
    // 地址
    private String address;
    // 省级代码
    private String province;
    // 市级代码
    private String city;
    // 证件资料
    private String certificateFile;
    // 账户code
    private String accountCode;
    // 身份证号码
    private String idCard;

    /**
     * 获取服务商编号code [主键]
     *
     * @return 服务商编号code
     */
    public String getServiceProviderCode() {
        return serviceProviderCode;
    }

    /**
     * 设置服务商编号code [主键]
     *
     * @param serviceProviderCode 服务商编号code
     */
    public void setServiceProviderCode(String serviceProviderCode) {
        this.serviceProviderCode = serviceProviderCode;
    }

    /**
     * 获取姓名
     *
     * @return 姓名
     */
    public String getServiceProviderName() {
        return serviceProviderName;
    }

    /**
     * 设置姓名
     *
     * @param serviceProviderName 姓名
     */
    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    /**
     * 获取所属行业
     *
     * @return 所属行业
     */
    public Industry getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业
     *
     * @param industry 所属行业
     */
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    /**
     * 获取性别
     *
     * @return 性别
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * 获取出生日期
     *
     * @return 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取邮箱地址
     *
     * @return 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取地址
     *
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取省级代码
     *
     * @return 省级代码
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省级代码
     *
     * @param province 省级代码
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市级代码
     *
     * @return 市级代码
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市级代码
     *
     * @param city 市级代码
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取证件资料
     *
     * @return 证件资料
     */
    public String getCertificateFile() {
        return certificateFile;
    }

    /**
     * 设置证件资料
     *
     * @param certificateFile 证件资料
     */
    public void setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
    }

    /**
     * 获取账户code
     *
     * @return 账户code
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * 设置账户code
     *
     * @param accountCode 账户code
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * 获取身份证号码
     *
     * @return 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

}