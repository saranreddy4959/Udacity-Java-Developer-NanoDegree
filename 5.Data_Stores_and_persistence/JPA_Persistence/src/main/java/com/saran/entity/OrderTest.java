package com.saran.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrderTest {


    private static final String PERSISTENCE_UNIT_NAME = "Order";

    private static EntityManagerFactory factory;

    public static void main(String[] args){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Order order = new Order();
        order.setCustomer_name("Saran Padala");
        order.setCustomer_address("857 Spiros Ct, Dekalb , IL, 60115");
        order.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));

        em.persist(order);

        System.err.println("Order ID:"+order.getOrderId());

        em.getTransaction().commit();
        em.close();

        readOrder(order.getOrderId(),factory);
        
        factory.close();
    }

    private static void readOrder(Integer orderId, EntityManagerFactory factory) {

        EntityManager em = factory.createEntityManager();

        Order order = em.find(Order.class, orderId);

        System.out.println("Order: "+order);

        em.close();

    }

}
