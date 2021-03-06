/**
 * 2016/9/27 19:51:49 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.entity 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.orderitem.entity;

import java.util.Date;

/**
 * 订单明细
 * Created by lenovo on 2016/09/27.
 */
public class OrderItem implements java.io.Serializable {

    // 序列化版本
    private static final long serialVersionUID = -3018538939309557248L;

    // 订单明细编号 [主键]
    private String orderItemCode;
    // 订单编号
    private String orderCode;
    // 商品编号
    private String commodityCode;
    // 交易数量
    private Double tradeAmount;
    // 交易价格
    private Double tradePrice;
    // 创建时间
    private Date createTime;

    /** 
     * 获取订单明细编号 [主键]
     * 
     * @return 订单明细编号
     */
    public String getOrderItemCode() {
        return orderItemCode;
    }

    /** 
     * 设置订单明细编号 [主键]
     * 
     * @param orderItemCode 订单明细编号
     */
    public void setOrderItemCode(String orderItemCode) {
        this.orderItemCode = orderItemCode;
    }

    /** 
     * 获取订单编号
     * 
     * @return 订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /** 
     * 设置订单编号
     * 
     * @param orderCode 订单编号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 
     * 获取商品编号
     * 
     * @return 商品编号
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /** 
     * 设置商品编号
     * 
     * @param commodityCode 商品编号
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    /** 
     * 获取交易数量
     * 
     * @return 交易数量
     */
    public Double getTradeAmount() {
        return tradeAmount;
    }

    /** 
     * 设置交易数量
     * 
     * @param tradeAmount 交易数量
     */
    public void setTradeAmount(Double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /** 
     * 获取交易价格
     * 
     * @return 交易价格
     */
    public Double getTradePrice() {
        return tradePrice;
    }

    /** 
     * 设置交易价格
     * 
     * @param tradePrice 交易价格
     */
    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
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

}
