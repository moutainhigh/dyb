/**
 * 2016/10/14 19:56:08 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.entity 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.conversioninvoicedetails.entity;

/**
 * 转换发票明细
 * Created by lenovo on 2016/10/14.
 */
public class ConversionInvoiceDetails implements java.io.Serializable {

    // 序列化版本
    private static final long serialVersionUID = -6736435455613041664L;

    // 转换发票明细编号code [主键]
    private String conversionInvoiceDetailsCode;
    // 发票号
    private String invoiceNum;
    // 发票面额
    private Double invoiceMoney;
    // 转换记录code
    private String conversionCode;

    /** 
     * 获取转换发票明细编号code [主键]
     * 
     * @return 转换发票明细编号code
     */
    public String getConversionInvoiceDetailsCode() {
        return conversionInvoiceDetailsCode;
    }

    /** 
     * 设置转换发票明细编号code [主键]
     * 
     * @param conversionInvoiceDetailsCode 转换发票明细编号code
     */
    public void setConversionInvoiceDetailsCode(String conversionInvoiceDetailsCode) {
        this.conversionInvoiceDetailsCode = conversionInvoiceDetailsCode;
    }

    /** 
     * 获取发票号
     * 
     * @return 发票号
     */
    public String getInvoiceNum() {
        return invoiceNum;
    }

    /** 
     * 设置发票号
     * 
     * @param invoiceNum 发票号
     */
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    /** 
     * 获取发票面额
     * 
     * @return 发票面额
     */
    public Double getInvoiceMoney() {
        return invoiceMoney;
    }

    /** 
     * 设置发票面额
     * 
     * @param invoiceMoney 发票面额
     */
    public void setInvoiceMoney(Double invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    /** 
     * 获取转换记录code
     * 
     * @return 转换记录code
     */
    public String getConversionCode() {
        return conversionCode;
    }

    /** 
     * 设置转换记录code
     * 
     * @param conversionCode 转换记录code
     */
    public void setConversionCode(String conversionCode) {
        this.conversionCode = conversionCode;
    }

}
