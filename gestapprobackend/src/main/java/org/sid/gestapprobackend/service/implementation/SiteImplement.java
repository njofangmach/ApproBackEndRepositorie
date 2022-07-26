package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.SiteRepository;
import org.sid.gestapprobackend.entities.Site;
import org.sid.gestapprobackend.service.interfaces.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SiteImplement implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Override
    public Site create_site(Site site) {
        if (!siteRepository.findByName(site.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!siteRepository.findByCode(site.getCode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code est deja utilisé");
        }
        return siteRepository.save(site);

    }

    @Override
    public Optional<Site> update_site(Site site) {
        Optional<Site> get_site = siteRepository.findById(Long.valueOf(site.getOid()));
        if (get_site.isPresent()) {
            if (!siteRepository.findByName(site.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!siteRepository.findByCode(site.getCode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            }
            get_site.get().setCode(site.getCode());
            get_site.get().setName(site.getName());
            siteRepository.save(get_site.get());
            return get_site;

        } else {
            throw new ResourceNotFoundException("Ce site n'existe pas");
        }
    }

    @Override
    public List<Site> list_site() {
        return siteRepository.findAll();
    }

    @Override
    public void delete_site(Integer id_site) {

    }

    public Optional<Site> finf_site_by_name(String name) {
        return siteRepository.findByName(name);
    }
}
