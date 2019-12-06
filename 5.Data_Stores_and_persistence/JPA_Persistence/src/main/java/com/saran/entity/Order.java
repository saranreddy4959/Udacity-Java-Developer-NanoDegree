package com.saran.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "created_time")
    private Timestamp created_time;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderItem> order;

    public Order(){}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customer_address) {
        this.customerAddress = customer_address;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItem> order) {
        this.order = order;
    }
}
