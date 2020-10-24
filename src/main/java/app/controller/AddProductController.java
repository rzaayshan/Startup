package app.controller;

import app.cloudinary.service.CloudinaryService;
import app.entity.Category;
import app.entity.Product;
import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class AddProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final CloudinaryService cloudinaryService;

    @GetMapping("add-product")
    public ModelAndView viewBoard(){
        ModelAndView mav = new ModelAndView("add_product");
        mav.addObject("cats", categoryService.getAll());
        return mav;
    }

    @PostMapping("add-product")
    public RedirectView addProduct(Product product, Long category, @RequestParam("pp") MultipartFile photo) throws IOException {
        byte[] file = photo.getBytes();
        product.setPhoto(cloudinaryService.uploadFile(file));
        product.setCategory(categoryService.getById(category));
        productService.insert(product);
        return new RedirectView("/success");
    }

    @GetMapping("all")
    public List<Category> get(){
        return categoryService.getAll();
    }
}
