package app.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@ControllerAdvice
public class XExceptionHandler {

    @ExceptionHandler(PassMismatchException.class)
    public RedirectView handlePassMismatch(Model model){
        model.addAttribute("exception", "passMismatch");
        return new RedirectView("/customer/signUp");
    }

    @ExceptionHandler(EmailIsUsedException.class)
    public RedirectView handleEmailIsUsed(Model model){
        System.out.println("In Handler Email");
        model.addAttribute("exception", "emailIsUsed");
        return new RedirectView("/customer/signUp");
    }


}
