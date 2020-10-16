package app.controller;

import app.entity.Category;
import app.entity.Product;
import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@AllArgsConstructor
public class ViewProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("products")
    public String vb(){
        return productService.getAll().toString();
    }

    @GetMapping("cats")
    public String vbn(){
        return categoryService.getById(8).getProducts().toString();
    }

}
