package app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.service.SailerService;

@Controller
@AllArgsConstructor
@RequestMapping("/sailer_login")
public class SailerController {
    private final SailerService sailerService;

}
