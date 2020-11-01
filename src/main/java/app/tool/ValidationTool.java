package app.tool;

import app.exception.EmailIsUsedException;
import app.exception.InvalidPhoneNumberException;
import app.exception.InvalidTinException;
import app.exception.PassMismatchException;
import app.repo.SellerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ValidationTool {

    private final SellerRepo sellerRepo;

    public long isParsable(String number){
        try{
            return Long.parseLong(number);

        }catch(NumberFormatException ex){
            throw new InvalidPhoneNumberException();
        }
    }

    public void checkPhone(String phone){
        long lPhone= isParsable(phone);

        if(lPhone<2000000 || lPhone>9999999){
            throw new InvalidPhoneNumberException();
        }
    }

    public void matchPassword(String password, String password2){
        if(!password.equals(password2)) throw new PassMismatchException();
    }

    public void isEmailUsed(String email){
        if(sellerRepo.findSellerByEmail(email).isPresent()) throw new EmailIsUsedException();
    }

    public void checkTin(String tin){
        isParsable(tin);
        if(tin.length()==12)
            throw new InvalidTinException();
    }

}
