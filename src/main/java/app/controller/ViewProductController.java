package app.controller;

import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
public class ViewProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("products")
    public ModelAndView vb(){
        ModelAndView mav = new ModelAndView("product");
        mav.addObject("products", productService.getAll());
        return mav;
    }

    @GetMapping("cats")
    public String vbn(){
        return categoryService.getById(8).getProducts().toString();
    }

}
