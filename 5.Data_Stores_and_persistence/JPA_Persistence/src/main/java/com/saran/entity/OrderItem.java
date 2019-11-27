package com.saran.entity;

import javax.persistence.*;

@Entity
@Table(name ="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Item_Id")
    private Integer orderItemId;

    @Column(name = "order_Item_Name")
    private String itemName;

    @Column(name = "Order_Item_Count")
    private int ItemCount;

    @ManyToOne
    @JoinColumn(name ="order_id")
    private Order order;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int itemCount) {
        ItemCount = itemCount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
