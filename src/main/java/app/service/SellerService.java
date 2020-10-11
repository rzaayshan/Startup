package app.service;

import app.entity.Seller;
import app.exception.EmailIsUsedException;
import app.exception.PassMismatchException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import app.repo.SellerRepo;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepo sailerRepo;

    public void signUp(String name, String surname, String email, String password, String password2, String company, String tel, String address, int voen){
        if(!password.equals(password2)) throw new PassMismatchException();

        if(sailerRepo.findSellerByEmail(email).isPresent()) throw new EmailIsUsedException();

        Seller seller = new Seller(name, surname, email, password, company, tel, address, voen);
        sailerRepo.save(seller);

    }

    public Optional<Seller> findUserForLogin(String company) {
        return sailerRepo.findSellerByCompany(company);
    }
}
