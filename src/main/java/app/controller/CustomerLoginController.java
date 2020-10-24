package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/customer")
public class CustomerLoginController {
    @GetMapping("/login")
    public String signIn_get(){
        return "login_customer";
    }

    @PostMapping("/login")
    public RedirectView signIn_post(){
        return new RedirectView("/dashboard");
    }
}
