package com.saran.bootstrap_dogs.service;

import com.saran.bootstrap_dogs.entity.Dog;
import com.saran.bootstrap_dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;


    public List<Dog> retreiveAllDogs() {
        return (List<Dog>) dogRepository.findAll();

    }


    public List<String> retreiveBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }


    public String retreiveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }


    public List<String> retreiveDogByNames() {
        return (List<String>) dogRepository.findAllName();
    }
}
