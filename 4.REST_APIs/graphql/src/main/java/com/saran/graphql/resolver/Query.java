package com.saran.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.saran.graphql.entity.Location;
import com.saran.graphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private LocationRepository locationRepository;


    public Query(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }
}
