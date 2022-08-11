package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Company;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@Component
@CrossOrigin("*")
public interface CompagnyService {
    Company create_compagny(Company compagny);

    Optional<Company> update_compagny(Company compagny);

    void delete_compagny(Long id_compagny);

    List<Company> list_compagny();

}
