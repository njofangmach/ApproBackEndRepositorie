package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Coastcenter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin("*")
public interface CoastcenterService {
    Coastcenter create_coastcenter(Coastcenter coastcenter);

    Optional<Coastcenter> update_coastcenter(Long id_coastcenter, Coastcenter coastcenter);

    void delete_coastcenter(Integer id_coastcenter);

    List<Coastcenter> list_coastcenter();
}

