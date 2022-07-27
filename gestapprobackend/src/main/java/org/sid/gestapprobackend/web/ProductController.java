package org.sid.gestapprobackend.web;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.ProductRepository;
import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.entities.Product;
import org.sid.gestapprobackend.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @PostMapping(value = "/add_product")
    public Product add_product(@RequestBody Product product) {
        return productService.create_product(product);
    }

    @PutMapping(value = "/update_prodcut/{id}")
    public Optional<Product> update_Product(@RequestBody Product product, @PathVariable Long id) {
        return productService.update_product(id, product);
    }

    @GetMapping(value = "/list_product")
    public List<Product> list_product() {
        return productService.list_product();
    }

    @GetMapping(value = "/list_product_by_location/{location}")
    public List<Product> list_product_by_location(@PathVariable Location location) {
        return productService.list_product_by_location(location);
    }

    @GetMapping(value = "/list_product_by_category/{category}")
    public List<Product> list_product_by_category(@PathVariable Category category) {
        return productService.list_product_by_category(category);
    }
}
