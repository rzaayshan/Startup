package app.controller;

import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@AllArgsConstructor
@RequestMapping("/verify")
public class VerifyController {
    private final SellerService sellerService;
    @GetMapping
    public String verify_get(){
        return "verify";
    }

    @PostMapping
    public RedirectView verify_post(@RequestParam(value = "email") String email, @RequestParam String token){
//        sellerService.checkToken(token,email);
        return new RedirectView("/seller-panel/login");
    }
}
