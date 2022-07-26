package org.sid.gestapprobackend.web;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CategoryRepository;
import org.sid.gestapprobackend.dao.CoastcenterRepository;
import org.sid.gestapprobackend.dao.CompagnyRepository;
import org.sid.gestapprobackend.dao.LocationRepository;
import org.sid.gestapprobackend.dao.ProviderRepoitory;
import org.sid.gestapprobackend.dao.SiteRepository;
import org.sid.gestapprobackend.dao.WarehouseRepository;
import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.entities.Coastcenter;
import org.sid.gestapprobackend.entities.Company;
import org.sid.gestapprobackend.entities.Site;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.entities.Provider;
import org.sid.gestapprobackend.entities.Warehouse;
import org.sid.gestapprobackend.service.interfaces.CategoryService;
import org.sid.gestapprobackend.service.interfaces.CoastcenterService;
import org.sid.gestapprobackend.service.interfaces.CompagnyService;
import org.sid.gestapprobackend.service.interfaces.LocationService;
import org.sid.gestapprobackend.service.interfaces.ProviderService;
import org.sid.gestapprobackend.service.interfaces.SiteService;
import org.sid.gestapprobackend.service.interfaces.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    @Autowired
    SiteRepository siteRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    ProviderRepoitory providerRepository;
    @Autowired
    CoastcenterRepository coastcenterRepository;
    @Autowired
    CompagnyRepository compagnyRepository;

    @Autowired
    SiteService siteService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    LocationService locationService;
    @Autowired
    ProviderService providerService;
    @Autowired
    CoastcenterService coastcenterService;
    @Autowired
    CompagnyService compagnyService;

    @PostMapping(value = "/add_site")
    public Site create_site(@RequestBody Site site) {
        return siteService.create_site(site);
    }

    @PutMapping(value = "/update_site/{id}")
    public Optional<Site> update_site(@RequestBody Site site, @PathVariable Integer id) {
        return siteService.update_site(site, id);
    }

    @GetMapping(value = "/list_site")
    public List<Site> list_site() {
        return siteService.list_site();
    }

    @GetMapping("/findSiteByName/{name}")
    public List<Site> findSiteByName(@PathVariable("name") String name) {
        return siteRepository.findAllByName(name);
    }

    @GetMapping("/findSiteById/{id}")
    public Optional<Site> findSiteById(@PathVariable("id") Long id) {
        return siteRepository.findById(id);
    }

    @PostMapping(value = "/add_warehouse")
    public Warehouse add_wWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.create_warehouse(warehouse);
    }

    @PutMapping(value = "/update_warehouse/{id}")
    public Optional<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable Long id) {
        return warehouseService.update_warehouse(warehouse, id);
    }

    @GetMapping(value = "/list_warehouse")
    public List<Warehouse> list_warehouse() {
        return warehouseService.list_warehouse();
    }

    @GetMapping(value = "list_warehouse_by_site/{site}")
    public List<Warehouse> ist_warehouse_by_site(@PathVariable Site site) {
        return warehouseService.list_warehouse_by_site(site);
    }

    @PostMapping(value = "/add_category")
    public Category add_category(@RequestBody Category category) {
        return categoryService.create_category(category);
    }

    @GetMapping(value = "/list_category")
    public List<Category> list_category() {
        return categoryService.list_category();
    }

    @PutMapping(value = "/update_category/{id}")
    public Optional<Category> update_category(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.update_category(category, id);
    }

    @PostMapping(value = "/add_location")
    public Location add_location(@RequestBody Location location) {
        return locationService.create_location(location);
    }

    @PutMapping(value = "/update_location/{id}")
    public Optional<Location> update_location(@RequestBody Location location, @PathVariable Long id) {
        return locationService.update_location(id, location);
    }

    @GetMapping(value = "/list_location")
    public List<Location> list_location() {
        return locationService.list_location();
    }

    @PostMapping(value = "/add_provider")
    public Provider add_provider(@RequestBody Provider provider) {
        return providerService.create_provider(provider);
    }

    @PutMapping(value = "/update_provider/{id}")
    public Optional<Provider> update_provider(@RequestBody Provider provider, @PathVariable Long id) {
        return providerService.update_provider(id, provider);
    }

    @GetMapping(value = "/list_provider")
    public List<Provider> list_Provider() {
        return providerService.list_location();
    }

    @PostMapping(value = "/add_coastcenter")
    public Coastcenter add_Coastcenter(@RequestBody Coastcenter coastcenter) {
        return coastcenterService.create_coastcenter(coastcenter);
    }

    @PutMapping(value = "/update_coastcenter/{id}")
    public Optional<Coastcenter> update_coastcenter(@RequestBody Coastcenter coastcenter, @PathVariable Long id) {
        return coastcenterService.update_coastcenter(id, coastcenter);
    }

    @GetMapping(value = "/list_coastcenter")
    public List<Coastcenter> list_coastcenter() {
        return coastcenterService.list_coastcenter();
    }

    @PostMapping(value = "/add_compagy")
    public Company add_compagy(@RequestBody Company compagny) {
        return compagnyService.create_compagny(compagny);
    }

    @PutMapping(value = "/update_compagny/{id}")
    public Optional<Company> update_compagny(@RequestBody Company company, @PathVariable Long id) {
        return compagnyService.update_compagny(id, company);
    }

    @GetMapping(value = "/list_compagny")
    public List<Company> list_compagny() {
        return compagnyService.list_compagny();
    }

}