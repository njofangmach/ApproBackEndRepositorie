package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Site;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Service
@CrossOrigin("*")
public interface SiteService {
    Site create_site(Site site);

    Optional<Site> update_site(Site site);

    List<Site> list_site();

    void delete_site(Integer id_site);

    
}
