package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.ProviderRepoitory;
import org.sid.gestapprobackend.entities.Provider;
import org.sid.gestapprobackend.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProviderImplement implements ProviderService {

    @Autowired
    ProviderRepoitory providerRepoitory;

    @Override
    public Provider create_provider(Provider provider) {
        List<Provider> get_provider = providerRepoitory.findByNameOrCode(provider.getName(), provider.getCode());
        if (get_provider.isEmpty()) {
            return providerRepoitory.save(provider);
        } else {
            throw new ResourceNotFoundException("This provider exist because code or name of this provider are already uset");
        }
    }

    @Override
    public Optional<Provider> update_provider(Long id_provider, Provider provider) {
        Optional<Provider> get_provider = providerRepoitory.findById(Long.valueOf(id_provider));
        if (get_provider.isPresent()) {
            if (get_provider.get().getName() == provider.getName()) {
                throw new ResourceNotFoundException("This provider name exist");
            } else if (get_provider.get().getCode() == provider.getCode()) {
                throw new ResourceNotFoundException("This provider code exist");
            } else {
                get_provider.get().setCode(provider.getCode());
                get_provider.get().setName(provider.getName());
                providerRepoitory.save(get_provider.get());
                return get_provider;
            }
        } else {
            throw new ResourceNotFoundException("Provider don't exist");
        }
    }

    @Override
    public void delete_provider(Integer id_provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Provider> list_location() {
        return providerRepoitory.findAll();
    }

}
