package com.saran.bootstrap.service;

import com.saran.bootstrap.entity.Location;
import com.saran.bootstrap.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();

    }
}
