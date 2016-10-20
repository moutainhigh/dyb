package com.dyb.platforms.fixfunds.common.controller.order.model;

import com.dyb.platforms.fixfunds.services.business.account.entity.Account;
import com.dyb.platforms.fixfunds.services.business.order.entity.Order;

/**
 * Created by lenovo on 2016/10/20.
 */
public class OrderModel {
    //订单信息
    private Order order;
    //信使信息
    private Account member;
    //商家信息
    private Account merchant;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Account getMember() {
        return member;
    }

    public void setMember(Account member) {
        this.member = member;
    }

    public Account getMerchant() {
        return merchant;
    }

    public void setMerchant(Account merchant) {
        this.merchant = merchant;
    }
}
