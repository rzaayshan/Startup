package app.controller;

import app.entity.Category;
import app.entity.Product;
import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@AllArgsConstructor
public class AddProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("add-product")
    public ModelAndView viewBoard(){
        ModelAndView mav = new ModelAndView("add_product");
        mav.addObject("cats", categoryService.getAll());
        return mav;
    }

    @PostMapping("add-product")
    public RedirectView addProduct(Product product, Long category){
        product.setCategory(categoryService.getById(category));
        productService.insert(product);
        return new RedirectView("/success");
    }

    @GetMapping("all")
    public List<Category> get(){
        return categoryService.getAll();
    }
}
