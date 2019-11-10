package com.saran.items.microservice.repository;

import com.saran.items.microservice.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {

}
