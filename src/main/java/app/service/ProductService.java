package app.service;

import app.entity.Product;
import app.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public void insert(Product product){
        productRepo.save(product);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }
}
