package app.service;

import app.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import app.repo.CustomerRepo;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public void signup(String name, String surname, String email, String password){
        Customer customer = new Customer(name, surname, email, password);
        customerRepo.save(customer);
    }



}
