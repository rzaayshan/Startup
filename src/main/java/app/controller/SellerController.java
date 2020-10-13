package app.controller;

import app.form.FormSeller;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
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
        return "seller_signUp";
    }

    @PostMapping("/signUp")
    public RedirectView signUp_post(FormSeller form){
        sellerService.signUp(form.getName(), form.getSurname(), form.getEmail(), form.getPassword(), form.getPassword2(),
                form.getCompany(), form.getTel(), form.getAddress(), form.getVoen());
        return new RedirectView("/seller/signIn");
    }

    @GetMapping("/signIn")
    public String signIn_get(){
        return "seller_signIn";
    }

    @PostMapping("/signIn")
    public RedirectView signIn_post(){
        return new RedirectView("/sellerDashboard");
    }

}
