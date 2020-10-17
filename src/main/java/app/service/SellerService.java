package app.service;

import app.Tool.ValidationTool;
import app.entity.Seller;
import app.exception.TokenMismatchException;
import app.repo.SellerRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepo sellerRepo;
    private final PasswordEncoder passwordEncoder;
    private final ValidationTool tool;
    private final SMSService smsService;

    public void signUp(String name, String surname, String email, String password, String password2, String company, String phone, String address, String tin){
        tool.matchPassword(password, password2);
        tool.isEmailUsed(email);
        tool.checkTin(tin);
//        validationTool.checkPhone(phone);

        int token = smsService.createSMSToken();
        System.err.println(password);
        Seller seller = new Seller(name, surname, email,
                passwordEncoder.encode(password) , company, phone, address, tin, Integer.toString(token));
        System.err.println(seller);
        sellerRepo.save(seller);
        smsService.createSMSRequest(phone, token);
        System.err.println("ses");
    }

    public Optional<Seller> findUserForLogin(String email) {
        return sellerRepo.findSellerByEmail(email);
    }

    public Optional<Seller> findSellerByCompany(String company){
        return sellerRepo.findSellerByCompany(company);
    }

    public void checkToken(String token, String email) {
        if(!sellerRepo.findSellerByEmail(email).orElseThrow(RuntimeException::new).getToken().equals(token))
            throw new TokenMismatchException(email);
    }
}
