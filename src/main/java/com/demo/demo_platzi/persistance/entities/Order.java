package com.demo.demo_platzi.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idOrder;

    @Column(name = "id_cliente")
    private String idClient;

    @Column(name="fecha")
    private LocalDateTime date;

    @Column(name="medio_pago")
    private String paymentMethod;

    @Column(name="comentario")
    private String comment;

    @Column(name="estado")
    private String status;

//    RELATIONSHIPS BETWEEN TABLES

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.ALL })
    private List<OrdersProduct> ordersProductList;


//    GETTERS AND SETTER

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

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public List<OrdersProduct> getOrdersProductList() {
        return ordersProductList;
    }

    public void setOrdersProductList(List<OrdersProduct> ordersProductList) {
        this.ordersProductList = ordersProductList;
    }
}
