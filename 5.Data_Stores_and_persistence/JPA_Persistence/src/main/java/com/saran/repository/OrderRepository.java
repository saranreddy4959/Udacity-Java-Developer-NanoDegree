package com.saran.repository;


import com.saran.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

   Optional<List<Order>> findByCustomerName(String customerName);

}
