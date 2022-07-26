package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Location;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin("*")
public interface LocationService {
    Location create_location(Location location);

    Optional<Location> update_location(Long id_location, Location location);

    //List<Location> list_product_by_location(Long id_location);

    List<Location> list_location();
}
