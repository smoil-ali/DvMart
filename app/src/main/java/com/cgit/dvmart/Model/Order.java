package com.cgit.dvmart.Model;

public class Order {
    String orderId;
    String itemTitle;
    String totalPrice;
    String date;


    public Order(String orderId, String itemTitle, String totalPrice, String date) {
        this.orderId = orderId;
        this.itemTitle = itemTitle;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
