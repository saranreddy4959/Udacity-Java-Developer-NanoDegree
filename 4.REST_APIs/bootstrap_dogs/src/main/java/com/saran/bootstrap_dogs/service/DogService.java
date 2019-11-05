package com.saran.bootstrap_dogs.service;

import com.saran.bootstrap_dogs.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retreiveAllDogs();
    List<String> retreiveBreed();
    String retreiveDogBreedById(Long id);
    List<String> retreiveDogByNames();

}
