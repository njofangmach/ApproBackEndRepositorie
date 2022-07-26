package org.sid.gestapprobackend.service.implemention;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CoastcenterRepository;
import org.sid.gestapprobackend.entities.Coastcenter;
import org.sid.gestapprobackend.service.interfaces.CoastcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class CoastCenterImplement implements CoastcenterService {

    @Autowired
    CoastcenterRepository coastcenterRepository;

    @Override
    public Coastcenter create_coastcenter(Coastcenter coastcenter) {
        List<Coastcenter> get_coastCenter = coastcenterRepository.findByNameOrCode(coastcenter.getName(),
                coastcenter.getCode());
        if (get_coastCenter.isEmpty()) {
            return coastcenterRepository.save(coastcenter);
        } else {
            throw new ResourceNotFoundException("This coast center exist");
        }
    }

    @Override
    public Optional<Coastcenter> update_coastcenter(Long id_coastcenter, Coastcenter coastcenter) {
        Optional<Coastcenter> get_coastCenter = coastcenterRepository.findById(Long.valueOf(id_coastcenter));
        if (get_coastCenter.isPresent()) {
            if (get_coastCenter.get().getName() == coastcenter.getName()) {
                throw new ResourceNotFoundException("This Coast center name exist");
            } else if (get_coastCenter.get().getCode() == coastcenter.getCode()) {
                throw new ResourceNotFoundException("This Coast center code exist");
            } else {
                get_coastCenter.get().setCode(coastcenter.getCode());
                get_coastCenter.get().setName(coastcenter.getName());
                coastcenterRepository.save(get_coastCenter.get());
                return get_coastCenter;
            }
        } else {
            throw new ResourceNotFoundException("Coast center don't exist");
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
