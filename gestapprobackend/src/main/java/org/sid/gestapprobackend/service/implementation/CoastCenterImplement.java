package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CoastcenterRepository;
import org.sid.gestapprobackend.entities.Coastcenter;
import org.sid.gestapprobackend.service.interfaces.CoastcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CoastCenterImplement implements CoastcenterService {

    @Autowired
    CoastcenterRepository coastcenterRepository;

    @Override
    public Coastcenter create_coastcenter(Coastcenter coastcenter) {
        if (!coastcenterRepository.findByName(coastcenter.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!coastcenterRepository.findByCode(coastcenter.getCode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code est deja utilisé");
        }
        return coastcenterRepository.save(coastcenter);

    }

    @Override
    public Optional<Coastcenter> update_coastcenter(Coastcenter coastcenter) {
        Optional<Coastcenter> get_coastCenter = coastcenterRepository.findById(Long.valueOf(coastcenter.getOid()));
        if (get_coastCenter.isPresent()) {
            if (!coastcenterRepository.findByName(coastcenter.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!coastcenterRepository.findByCode(coastcenter.getCode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            }
            get_coastCenter.get().setCode(coastcenter.getCode());
            get_coastCenter.get().setName(coastcenter.getName());
            coastcenterRepository.save(get_coastCenter.get());
            return get_coastCenter;

        } else {
            throw new ResourceNotFoundException("Cette imputation n'existe pas");
        }
    }

    @Override
    public void delete_coastcenter(Integer id_coastcenter) {

    }

    @Override
    public List<Coastcenter> list_coastcenter() {
        return coastcenterRepository.findAll();
    }

}
