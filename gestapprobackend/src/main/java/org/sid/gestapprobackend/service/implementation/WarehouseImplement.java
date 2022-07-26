package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.WarehouseRepository;
import org.sid.gestapprobackend.entities.Site;
import org.sid.gestapprobackend.entities.Warehouse;
import org.sid.gestapprobackend.service.interfaces.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WarehouseImplement implements WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public Warehouse create_warehouse(Warehouse warehouse) {
        List<Warehouse> getwarehouse = warehouseRepository.findByNameAndCodeAndSite(warehouse.getName(),
                warehouse.getCode(), warehouse.getSite());
        if (getwarehouse.isEmpty()) {
            return warehouseRepository.save(warehouse);
        } else {
            throw new ResourceNotFoundException("This site exist");
        }
    }

    @Override
    public Optional<Warehouse> update_warehouse(Warehouse warehouse, Long id_warehoue) {
        Optional<Warehouse> get_warehouse = warehouseRepository.findById(id_warehoue);
        if (get_warehouse.isPresent()) {
            if (get_warehouse.get().getName() == warehouse.getName()) {
                throw new ResourceNotFoundException("This Warehouse name exist");
            } else if (get_warehouse.get().getCode() == warehouse.getCode()) {
                throw new ResourceNotFoundException("This warehouse code exist");
            } else {
                get_warehouse.get().setCode(warehouse.getCode());
                get_warehouse.get().setName(warehouse.getName());
                get_warehouse.get().setSite(warehouse.getSite());
                warehouseRepository.save(get_warehouse.get());
                return get_warehouse;
            }
        } else {
            throw new ResourceNotFoundException("Warehouse don't exist");
        }
    }

    @Override
    public List<Warehouse> list_warehouse() {
        return warehouseRepository.findAll();
    }

    @Override
    public void delete_warehouse(Integer id_warehouse) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Warehouse> list_warehouse_by_site(Site site) {
        return warehouseRepository.findAllBySite(site);
    }

}
