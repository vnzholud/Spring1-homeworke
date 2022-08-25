package ru.zholud.spring1homeworke4.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zholud.spring1homeworke4.data.Product;
import ru.zholud.spring1homeworke4.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/products")

    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {

        productService.deleteById(id);
    }

    @GetMapping("/products/change_amount")
    public void changAmount(@RequestParam Long productId, @RequestParam Integer delta) {

        productService.changAmount(productId, delta);
    }

}
