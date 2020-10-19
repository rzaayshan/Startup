package app.controller;

import app.entity.Product;
import app.security.CustomerDetails;
import app.service.BagService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/my-bag")
public class MyBagController {

    private final BagService bagService;

    @GetMapping()
    public String showMyBag(Model model, Authentication auth) {
        CustomerDetails curUser = (CustomerDetails) auth.getPrincipal();
        List<Product> products = bagService.getBagContent(curUser.getId());
        if (products.isEmpty()) return "bag-empty";
        model.addAttribute("products", products);
        return "bag";
    }

    @PostMapping("/add-to-bag")
    public RedirectView addToBag(Authentication auth, @RequestParam long productId) {
        CustomerDetails curUser = (CustomerDetails) auth.getPrincipal();
        bagService.addProduct(curUser.getId(), productId);
        return new RedirectView("/dashboard");
    }

}
