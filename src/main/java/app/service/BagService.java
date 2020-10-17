package app.service;

import app.entity.Bag;
import app.entity.Product;
import app.exception.AppException;
import app.exception.ProductNotFoundException;
import app.repo.BagRepo;
import app.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BagService {

    private final BagRepo bagRepo;
    private final ProductRepo productRepo;

    public List<Product> getBagContent(long customerId) {
        return bagRepo.findById(customerId).orElseThrow(AppException::new).getProducts();
    }

    public void addProduct(long bagId, long productId) {
        Product product = productRepo.findById(productId).orElseThrow(ProductNotFoundException::new);
        Bag bag = bagRepo.findById(bagId).orElseThrow(AppException::new);
        bag.getProducts().add(product);
        bagRepo.save(bag);
    }
}
