package com.demo.demo_platzi.persistance.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class OrdersProduct {
    @EmbeddedId
    private OrdersProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    public OrdersProductPK getId() {
        return id;
    }

    public void setId(OrdersProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
