package app.controller;

import app.entity.Seller;
import app.entity.Style;
import app.security.SellerDetails;
import app.service.CategoryService;
import app.service.ProductService;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/seller")
public class ViewProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SellerService sellerService;

    @GetMapping("products")
    public ModelAndView getProducts(Authentication auth){
        ModelAndView mav = new ModelAndView("product");
        SellerDetails sellerDetails = (SellerDetails) auth.getPrincipal();
        Seller seller = sellerService.findbyId(sellerDetails.getId());
        Style style = seller.getStyle();
        String company = seller.getCompany();
        mav.addObject("products", productService.getAll(seller));
        mav.addObject("style", style);
        mav.addObject("company", company);
        mav.addObject("user", seller);
        return mav;
    }

    @GetMapping("product/{id}")
    public ModelAndView getProduct(@PathVariable long id){
        ModelAndView mav = new ModelAndView("seller_quick_view_2");
        mav.addObject("product", productService.getById(id));
        return mav;
    }

}
