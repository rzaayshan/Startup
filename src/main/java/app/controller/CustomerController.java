package app.controller;

import app.form.FormCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import app.service.CustomerService;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/signUp")
    public String signUp_get(){
        return "customer_signUp";
    }

    @PostMapping("/signUp")
    public RedirectView signUp_post(FormCustomer form){
        customerService.signUp(form.getName(), form.getSurname(), form.getEmail(), form.getPassword(), form.getPassword2());
        return new RedirectView("/customer/signIn");
    }

    @GetMapping("/signIn")
    public String signIn_get(){
        return "customer_signIn";
    }

    @PostMapping("/signIn")
    public RedirectView signIn_post(){
        return new RedirectView("/dashboard");
    }
}
