package com.saran;


import com.saran.entity.Order;
import com.saran.entity.OrderItem;
import com.saran.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
public class Lesson2Application {

    private static final Logger log = LoggerFactory.getLogger(Lesson2Application.class);

    public static void main(String[] args){
        SpringApplication.run(Lesson2Application.class);
    }

    @Bean
    public CommandLineRunner demo(OrderRepository repository){
        return (args) -> {

            Order order = new Order();
            order.setCustomerName("Saran");
            order.setCustomerAddress("857 Spiros Ct, Dekalb , IL, 60115");
            order.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));

            OrderItem orderItem = new OrderItem();
            orderItem.setItemName("Oil");
            orderItem.setItemCount(3);
            orderItem.setOrder(order);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setItemName("Soap");
            orderItem1.setItemCount(2);
            orderItem1.setOrder(order);

            order = repository.save(order);

            System.err.println("Order ID:"+ order.getOrderId());

            Optional<List<Order>> orderRead = repository.findByCustomerName("Saran");

           //orderRead.ifPresent(value -> System.err.println("Order: "+value));


        };
    }

}
