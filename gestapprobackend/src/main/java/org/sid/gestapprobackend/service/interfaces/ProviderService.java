package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Provider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Service
@CrossOrigin("*")
public interface ProviderService {
    Provider create_provider(Provider provider);

    Optional<Provider> update_provider(Long id_provider, Provider provider);

    void delete_provider(Integer id_provider);

    List<Provider> list_location();
}
