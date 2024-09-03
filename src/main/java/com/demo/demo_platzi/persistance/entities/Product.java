package com.demo.demo_platzi.persistance.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProduct;

    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name="nombre")
    private String name;

    @Column(name="codigo_barras")
    private String barCode;

    @Column(name="precio_venta")
    private Double sellPrice;

    @Column(name="cantidad_stock")
    private Integer stockQuantity;

    @Column(name="estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrdersProduct> ordersProductList;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrdersProduct> getOrdersProductList() {
        return ordersProductList;
    }

    public void setOrdersProductList(List<OrdersProduct> ordersProductList) {
        this.ordersProductList = ordersProductList;
    }
}
