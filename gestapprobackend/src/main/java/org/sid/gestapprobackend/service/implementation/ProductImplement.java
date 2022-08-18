package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.ProductRepository;
import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.entities.Product;
import org.sid.gestapprobackend.entities.Walkin;
import org.sid.gestapprobackend.entities.Walkout;
import org.sid.gestapprobackend.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create_product(Product product) {
        if (!productRepository.findByName(product.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!productRepository.findByBarrecode(product.getBarrecode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code barre est deja utilisé");
        }
        return productRepository.save(product);

    }

    @Override
    public Optional<Product> update_product(Product product) {
        Optional<Product> get_product = productRepository.findById(product.getOid());
        if (get_product.isPresent()) {
            if (!productRepository.findByName(product.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!productRepository.findByBarrecode(product.getBarrecode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code barre est deja utilisé");
            }
            get_product.get().setName(product.getName());
            get_product.get().setDescription(product.getDescription());
            get_product.get().setBarrecode(product.getBarrecode());
            get_product.get().setBuyingprice(product.getBuyingprice());
            get_product.get().setSellingprice(product.getSellingprice());
            get_product.get().setQtystock(product.getQtystock());
            get_product.get().setQtyreapro(product.getQtyreapro());
            get_product.get().setQtyalert(product.getQtyalert());
            get_product.get().setTva(product.getTva());
            get_product.get().setLocation(product.getLocation());
            get_product.get().setCategory(product.getCategory());
            productRepository.save(get_product.get());
            return get_product;

        } else {
            throw new ResourceNotFoundException("this product don't exist");
        }
    }

    @Override
    public List<Product> list_product() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> list_product_by_location(Location location) {
        return productRepository.findByLocation(location);
    }

    @Override
    public List<Product> list_product_by_category(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> list_product_by_warehouse(Long id_warehouse) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> list_product_by_site(Long id_site) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> list_product_by_command(Long id_command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Walkin create_walkin(Walkin walkin) {

        return null;
    }

    @Override
    public Walkin create_walkout(Walkout walkout) {
        // TODO Auto-generated method stub
        return null;
    }

}
