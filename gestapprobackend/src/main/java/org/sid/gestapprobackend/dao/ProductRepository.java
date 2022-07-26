package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.entities.Location;
import org.sid.gestapprobackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    List<Product> findByNameOrBarrecode(String name, String barecode);

    //Optional<Product> findByNameOrbarrevode(String name, String barrecode);

    java.util.List<Product> findAllByName(String name);

    java.util.List<Product> findByLocation(Location location);

    java.util.List<Product> findByCategory(Category category);
    //
}