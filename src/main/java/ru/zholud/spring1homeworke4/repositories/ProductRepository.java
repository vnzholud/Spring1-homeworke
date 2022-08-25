package ru.zholud.spring1homeworke4.repositories;



import org.springframework.stereotype.Component;
import ru.zholud.spring1homeworke4.data.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milch", 32L, 10),
                new Product(2L, "Brot", 25L, 25),
                new Product(3L, "Buter", 120L, 30),
                new Product(4L, "Fleich", 420L, 40),
                new Product(5L, "Wein", 1250L, 70),
                new Product(6L, "Case", 330L, 450),
                new Product(7L, "Wasser", 150L, 230)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().get();

    }


    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public void add(Product p) {

        products.add(p);

    }
}
