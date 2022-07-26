package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Site;
import org.sid.gestapprobackend.entities.Warehouse;
import org.springframework.stereotype.Component;

@Component
public interface WarehouseService {
    Warehouse create_warehouse(Warehouse warehouse);

    Optional<Warehouse> update_warehouse(Warehouse warehouse, Long id);

    List<Warehouse> list_warehouse();

    List<Warehouse> list_warehouse_by_site(Site site);

    void delete_warehouse(Integer id_warehouse);
}
