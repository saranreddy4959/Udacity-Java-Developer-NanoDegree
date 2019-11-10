package com.saran.microservicedogdata.repository;

import com.saran.microservicedogdata.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
