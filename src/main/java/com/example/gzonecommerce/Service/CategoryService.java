package com.example.gzonecommerce.Service;

import com.example.gzonecommerce.Model.Category;
import com.example.gzonecommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category c) {
        categoryRepository.save(c);
    }

    public void delCategory(int i) {
        categoryRepository.deleteById(i);
    }

    public Optional<Category> getCategoryByID(int i) {
        return categoryRepository.findById(i);
    }
}
