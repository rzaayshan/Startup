package app.controller;

import app.entity.Seller;
import app.security.SellerDetails;
import app.service.CategoryService;
import app.service.ProductService;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        SellerDetails sellerDetails = (SellerDetails) auth.getPrincipal();
        Seller seller = sellerService.findbyId(sellerDetails.getId());
        ModelAndView mav = new ModelAndView("product");
        mav.addObject("products", productService.getAll(seller));
        return mav;
    }

}
