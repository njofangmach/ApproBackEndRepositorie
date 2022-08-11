package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.entities.Product;
import org.sid.gestapprobackend.entities.Walkin;
import org.sid.gestapprobackend.entities.Walkout;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Service
@CrossOrigin("*")
public interface ProductService {
    Product create_product(Product product);

    Optional<Product> update_product( Product product);

    List<Product> list_product();

    List<Product> list_product_by_location(Location location);

    List<Product> list_product_by_category(Category category);

    List<Product> list_product_by_warehouse(Long id_warehouse);

    List<Product> list_product_by_site(Long id_site);

    List<Product> list_product_by_command(Long id_command);

    Walkin create_walkin(Walkin walkin);

    Walkin create_walkout(Walkout walkout);

}
