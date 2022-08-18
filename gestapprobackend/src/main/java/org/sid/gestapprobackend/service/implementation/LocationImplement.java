package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.LocationRepository;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LocationImplement implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location create_location(Location location) {
        if (!locationRepository.findByName(location.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!locationRepository.findByCode(location.getCode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code est deja utilisé");
        }
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> update_location(Location location) {
        Optional<Location> get_location = locationRepository.findById(Long.valueOf(location.getOid()));
        if (get_location.isPresent()) {
            if (!locationRepository.findByName(location.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!locationRepository.findByCode(location.getCode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            }
            get_location.get().setCode(location.getCode());
            get_location.get().setName(location.getName());
            locationRepository.save(get_location.get());
            return get_location;

        } else {
            throw new ResourceNotFoundException("Cet emplacement n'existe pas");
        }
    }

    @Override
    public List<Location> list_location() {
        return locationRepository.findAll();
    }

}
