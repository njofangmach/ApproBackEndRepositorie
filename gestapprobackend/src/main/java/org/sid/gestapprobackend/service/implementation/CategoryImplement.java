package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CategoryRepository;
import org.sid.gestapprobackend.entities.Category;
import org.sid.gestapprobackend.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryImplement implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category create_category(Category category) {
        if (!categoryRepository.findByName(category.getName()).isEmpty()) {
            throw new ResourceNotFoundException("Ce nom est deja utilisé");
        }
        if (!categoryRepository.findByCode(category.getCode()).isEmpty()) {
            throw new ResourceNotFoundException("Ce code est deja utilisé");
        }
        return categoryRepository.save(category);

    }

    @Override
    public Optional<Category> update_category(Category category) {
        Optional<Category> get_category = categoryRepository.findById(category.getOid());
        if (get_category.isPresent()) {
            if (!categoryRepository.findByName(category.getName()).isEmpty()) {
                throw new ResourceNotFoundException("Ce nom est deja utilisé");
            }
            if (!categoryRepository.findByCode(category.getCode()).isEmpty()) {
                throw new ResourceNotFoundException("Ce code est deja utilisé");
            }
            get_category.get().setCode(category.getCode());
            get_category.get().setName(category.getName());
            categoryRepository.save(get_category.get());
            return get_category;

        } else {
            throw new ResourceNotFoundException("Cette categorie n'existe pas");
        }
    }

    @Override
    public void delete_category(Long id_category) {

    }

    @Override
    public List<Category> list_category() {
        return categoryRepository.findAll();
    }

}
