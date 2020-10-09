package app.service;

import app.entity.Sailer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import app.repo.SailerRepo;

@Service
@AllArgsConstructor
public class SailerService {
    private final SailerRepo sailerRepo;

    public void register(String name, String surname, String email, String password, String company, String tel, String address, int voen){
        Sailer sailer = new Sailer(name, surname, email, password, company, tel, address, voen);
        sailerRepo.save(sailer);
    }
}
