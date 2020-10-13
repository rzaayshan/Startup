package app.controller;

import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AddProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("add-product")
    public ModelAndView addProduct(){
        ModelAndView mav = new ModelAndView("add_product");
        mav.addObject("parent_cats", categoryService.getParentCategories());
        return mav;
    }
}
