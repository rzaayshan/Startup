package app.controller;

import app.entity.Category;
import app.service.CategoryService;
import app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
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

    @GetMapping("all")
    public List<Category> get(){
        return categoryService.getById();
    }

    @RequestMapping(value="/getChilds")
    @ResponseBody
    public List<Category> getChildren(@RequestParam(value="id", required = false, defaultValue="") Long id)  {
        System.out.println(id);
        System.out.println(categoryService.getChilds(id));
        return categoryService.getChilds(id);
    }
}
