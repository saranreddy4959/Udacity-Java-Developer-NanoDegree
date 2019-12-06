package com.saran;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.saran.entity.Order;
import com.saran.repository.OrderRepository;
import org.apache.catalina.servlets.DefaultServlet;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.activation.DataSource;
import javax.persistence.EntityManager;


import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;

    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(testEntityManager).isNotNull();
        assertThat(orderRepository).isNotNull();
    }

    @Test
    public void testFindByCustomerName(){
        // create Order
        Order order = new Order();
        // set fields
        order.setCustomerName("Saran Padala");

        entityManager.persist(order);

        Optional<List<Order>> actual = orderRepository.findByCustomerName("Saran Padala");
        if (actual.isPresent()){
            List<Order> orders = actual.get();
            //orders.forEach(o -> System.out.println(o.getOrderId() + " " + o.getCustomerName()));
            assertEquals(orders.get(0).getOrderId(), order.getOrderId());
        }
    }
}


