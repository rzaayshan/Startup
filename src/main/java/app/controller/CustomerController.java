package app.controller;

import app.form.FormCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import app.service.CustomerService;

@Controller
@AllArgsConstructor
@RequestMapping("/customer_signup")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String signup_get(){
        return "customer_signup";
    }

    @PostMapping
    public ModelAndView signup_post(FormCustomer form){
        customerService.signup(form.name, form.surname, form.email, form.password);
        return new RedirectView("/signin");
    }
}
