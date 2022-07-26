package org.sid.gestapprobackend.service.implemention;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.LocationRepository;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class LocationImplement implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location create_location(Location location) {
        List<Location> getLocation = locationRepository.findByNameOrCode(location.getName(), location.getCode());
        if (getLocation.isEmpty()) {
            return locationRepository.save(location);
        } else {
            throw new ResourceNotFoundException("This location exist");
        }
    }

    @Override
    public Optional<Location> update_location(Long id_location, Location location) {
        Optional<Location> get_location = locationRepository.findById(Long.valueOf(id_location));
        if (get_location.isPresent()) {
            if (get_location.get().getName() == location.getName()) {
                throw new ResourceNotFoundException("This location name exist");
            } else if (get_location.get().getCode() == location.getCode()) {
                throw new ResourceNotFoundException("This location code exist");
            } else {
                get_location.get().setCode(location.getCode());
                get_location.get().setName(location.getName());
                locationRepository.save(get_location.get());
                return get_location;
            }
        } else {
            throw new ResourceNotFoundException("Location don't exist");
        }
    }

    @Override
    public List<Location> list_location() {
        return locationRepository.findAll();
    }

}
