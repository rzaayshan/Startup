package app.controller;

import app.entity.Seller;
import app.entity.Style;
import app.form.FormSeller;
import app.form.FormStyle;
import app.security.SellerDetails;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
@RequestMapping("/seller")
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/signUp")
    public String signUp_get(){
        return "sailer_signup";
    }

    @PostMapping("/signUp")
    public RedirectView signUp_post(FormSeller seller, FormStyle style){
        sellerService.register(seller, style);
        return new RedirectView(String.format("/verify?email=%s",seller.getEmail()));
    }

    @GetMapping("/dashboard")
    public String handle_getSeller(Model model, Authentication authentication){
        Seller seller = sellerService.findSellerByEmail(getLoggedUser(authentication).getUsername()).orElseThrow(RuntimeException::new);
        Style style = seller.getStyle();
        String company = seller.getCompany();
        model.addAttribute("style", style);
        model.addAttribute("company", company);
        model.addAttribute("user", seller);
        return "inbox";
    }


    SellerDetails getLoggedUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        System.out.println(principal.toString());
        return (SellerDetails) principal;
    }


}
