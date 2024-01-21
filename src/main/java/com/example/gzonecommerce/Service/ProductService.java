package com.example.gzonecommerce.Service;

import com.example.gzonecommerce.Model.Category;
import com.example.gzonecommerce.Model.Product;
import com.example.gzonecommerce.Repository.CategoryRepository;
import com.example.gzonecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllCategory() {
        return productRepository.findAll();
    }

}
