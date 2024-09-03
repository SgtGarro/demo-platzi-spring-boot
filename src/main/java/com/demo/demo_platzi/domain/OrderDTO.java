package com.demo.demo_platzi.domain;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<OrderItemDTO> orderList;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderItemDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItemDTO> orderList) {
        this.orderList = orderList;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
