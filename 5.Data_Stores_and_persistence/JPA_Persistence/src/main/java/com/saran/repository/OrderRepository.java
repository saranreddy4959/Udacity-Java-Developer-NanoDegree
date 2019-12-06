package com.saran.repository;


import com.saran.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    Optional<Order> findByCustomerName(String customerName);

}
