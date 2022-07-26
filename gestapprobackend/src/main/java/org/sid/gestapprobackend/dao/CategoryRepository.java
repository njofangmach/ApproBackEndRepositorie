package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    List<Category> findByNameOrCode(String name, String code);

    Optional<Category> findAllByNameOrCode(String name, String code);

    java.util.List<Category>findAllByName(String name);
}
