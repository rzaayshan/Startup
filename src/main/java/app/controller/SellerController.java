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
        return "signup_seller";
    }

    @PostMapping("/signUp")
    public RedirectView signUp_post(FormSeller form){
        sellerService.signUp(form.getName(), form.getSurname(), form.getEmail(), form.getPassword(), form.getPassword2(),
                form.getCompany(), form.getPhone(), form.getAddress(), form.getTin());

        String email=form.getEmail();
        return new RedirectView(String.format("/verify?email=%s",email));
    }


    @GetMapping("/dashboard")
    public String handle_getSeller(){
        return "sellerDashboard";
    }


}
