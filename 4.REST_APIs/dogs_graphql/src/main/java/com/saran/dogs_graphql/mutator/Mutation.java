package com.saran.dogs_graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.saran.dogs_graphql.entity.Dog;
import com.saran.dogs_graphql.exception.BreedNotFoundException;
import com.saran.dogs_graphql.exception.DogNotFoundException;
import com.saran.dogs_graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    private DogRepository dogRepository;

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> dogs = dogRepository.findAll();

        for(Dog d: dogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }

        else{
            throw new DogNotFoundException("DogNotFound", id);
        }
    }


}
