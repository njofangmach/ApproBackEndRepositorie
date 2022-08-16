package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CompagnyRepository;
import org.sid.gestapprobackend.entities.Company;
import org.sid.gestapprobackend.service.interfaces.CompagnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompagnyImplement implements CompagnyService {

    @Autowired
    CompagnyRepository compagnyRepository;

    @Override
    public Company create_compagny(Company compagny) {
        List<Company> getLocation = compagnyRepository.findByCode(compagny.getCode());
        if (getLocation.isEmpty()) {
            return compagnyRepository.save(compagny);
        } else {
            throw new ResourceNotFoundException("Cette compagnie existe deja");
        }
    }

    @Override
    public Optional<Company> update_compagny(Company compagny) {
        Optional<Company> get_compagny = compagnyRepository.findById(compagny.getOid());
        System.out.println(compagny);
        if (get_compagny.isPresent()) {
            if (get_compagny.get().getName() == compagny.getName()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            } else if (get_compagny.get().getCode() == compagny.getCode()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            } else {
                get_compagny.get().setCode(compagny.getCode());
                get_compagny.get().setName(compagny.getName());
                compagnyRepository.save(get_compagny.get());
                return get_compagny;
            }
        } else {
            throw new ResourceNotFoundException("Cette compagnie n'existe pas");
        }
    }

    @Override
    public void delete_compagny(Long id_compagny) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Company> list_compagny() {
        return compagnyRepository.findAll();
    }

}
