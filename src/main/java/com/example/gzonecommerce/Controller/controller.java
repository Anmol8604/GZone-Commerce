package com.example.gzonecommerce.Controller;

import com.example.gzonecommerce.Model.Category;
import com.example.gzonecommerce.Service.CategoryService;
import com.example.gzonecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class controller {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String adminCategories(Model model){
        categoryService.getAllCategory();
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String adminCategoriesAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping ("/admin/categories/add")
    public String adminCategoriesAddPost(@ModelAttribute("category") Category c){
        categoryService.addCategory(c);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String adminDeleteCategories(@PathVariable int id){
        categoryService.delCategory(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String adminUpdateCategories(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryByID(id);

        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else {
            return "404";
        }
    }

    // Product Section :--

    @Autowired
    ProductService productService;

    @GetMapping("/admin/products")
    public String products(Model model){
        productService.getAllCategory();
        model.addAttribute("products", productService.getAllCategory());
        return "products";
    }

}
