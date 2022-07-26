package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public interface CategoryService {
    Category create_category(Category category);

    Optional<Category> update_category(Category category, Long id_category);

    void delete_category(Long id_category);

    //List<Category> list_product_by_category(Long id_category);

    List<Category> list_category();
}
