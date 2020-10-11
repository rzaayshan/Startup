package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String handle_get(){
        return "dashboard";
    }
    @GetMapping("/sellerDashboard")
    public String handle_getSeller(){
        return "sellerDashboard";
    }
}
