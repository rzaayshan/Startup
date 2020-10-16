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
        model.addAttribute("exception", "emailIsUsed");
        return new RedirectView("/customer/signUp");
    }

    @ExceptionHandler(InvalidSMSRequestException.class)
    public RedirectView handleInvalidSMSReqExc(Model model){
        model.addAttribute("exception", "InvalidSMSRequestException");
        return new RedirectView("/seller/signUp");
    }

    @ExceptionHandler(TokenMismatchException.class)
    public RedirectView handleTokenMismatchExc(Model model, TokenMismatchException exc){
        model.addAttribute("exception", "InvalidSMSRequestException");
        return new RedirectView(String.format("/verify?email=%s", exc.email));
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public RedirectView handleInvalidPhoneEx(Model model){
        model.addAttribute("exception", "InvalidPhoneNumEx}");
        return new RedirectView("/seller/signUp");
    }

    @ExceptionHandler(InvalidTinException.class)
    public RedirectView handleInvalidTinEx(Model model){
        model.addAttribute("exception", "InvalidTinEx}");
        return new RedirectView("/seller/signUp");
    }

    @ExceptionHandler(SignUpEmptyInputEx.class)
    public RedirectView handleSignUpEmptyEx(Model model){
        model.addAttribute("exception", "SignUpEmpty");
        return new RedirectView("/seller/signUp");
    }




}
