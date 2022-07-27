package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Warehouse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin("*")
@Service
public interface CwarehouseService {
    Warehouse create_warehouse(Warehouse warehouse);

    Optional<Warehouse> update_command(Integer id_warehouse);

    void delete_warehouse(Integer id_warehouse);

    List<Warehouse> list_warehouse();
}


