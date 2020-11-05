package app.service;

import app.entity.Style;
import app.exception.SellerNotFoundException;
import app.form.FormSeller;
import app.form.FormStyle;
import app.repo.StyleRepo;
import app.tool.ValidationTool;
import app.entity.Seller;
import app.exception.TokenMismatchException;
import app.repo.SellerRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepo sellerRepo;
    private final PasswordEncoder passwordEncoder;
    private final ValidationTool tool;
    private final SMSService smsService;
    private final StyleRepo styleRepo;

    public void signUp(String name, String surname, String email, String password, String password2, String company, String phone, String address, String tin){
        tool.matchPassword(password, password2);
        tool.isEmailUsed(email);
        tool.checkTin(tin);
//        validationTool.checkPhone(phone);

        int token = smsService.createSMSToken();

        Seller seller = new Seller(name, surname, email,
                passwordEncoder.encode(password) , company, phone, address, tin, Integer.toString(token));

        sellerRepo.save(seller);
//        smsService.createSMSRequest(phone, token);

    }

    public void checkToken(String token, String email) {
        if(!sellerRepo.findSellerByEmail(email).orElseThrow(RuntimeException::new).getToken().equals(token))
            throw new TokenMismatchException(email);
    }

    public void register(FormSeller seller, FormStyle style) {
        tool.matchPassword(seller.getPassword(), seller.getPassword2());
        tool.isEmailUsed(seller.getEmail());
        tool.checkTin(seller.getTin());
//        validationTool.checkPhone(seller.getPhone());

        int token = smsService.createSMSToken();
        System.out.println(seller.toString());
        System.out.println(style.toString());
        Style style_saved = new Style(style.getFont(), style.getColor_back(), style.getColor());
        styleRepo.save(style_saved);

        Seller seller_saved = new Seller(seller.getName(), seller.getSurname(), seller.getEmail(),
                passwordEncoder.encode( seller.getPassword()), seller.getCompany(), seller.getPhone(), seller.getAddress(),
                seller.getTin(), Integer.toString(token), "SELLER", style_saved);

        sellerRepo.save(seller_saved);
    }

    public Optional<Seller> findSellerByEmail(String email) {
        return sellerRepo.findSellerByEmail(email);
    }

    public Seller findbyId(long id){
        return sellerRepo.findById(id).orElseThrow(SellerNotFoundException::new);
    }
}
