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
        if (!warehouseRepository.findByName(warehouse.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!warehouseRepository.findByCode(warehouse.getCode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code est deja utilisé");
        }
        return warehouseRepository.save(warehouse);

    }

    @Override
    public Optional<Warehouse> update_warehouse(Warehouse warehouse) {
        Optional<Warehouse> get_warehouse = warehouseRepository.findById(warehouse.getOid());
        if (get_warehouse.isPresent()) {
            if (!warehouseRepository.findByName(warehouse.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!warehouseRepository.findByCode(warehouse.getCode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            }
            get_warehouse.get().setCode(warehouse.getCode());
            get_warehouse.get().setName(warehouse.getName());
            get_warehouse.get().setSite(warehouse.getSite());
            warehouseRepository.save(get_warehouse.get());
            return get_warehouse;

        } else {
            throw new ResourceNotFoundException("C'est entrepot n'existe pas");
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
