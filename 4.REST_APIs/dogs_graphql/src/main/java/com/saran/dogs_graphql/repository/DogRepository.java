package com.saran.dogs_graphql.repository;

import com.saran.dogs_graphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;


public interface DogRepository extends CrudRepository<Dog,Long> {

}
