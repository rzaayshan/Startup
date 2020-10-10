package app.service;

import app.entity.Customer;
import app.exception.EmailIsUsedException;
import app.exception.PassMismatchException;
import app.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;

    public void signUp(String name, String surname, String email, String password, String password2){
        //if(!password.equals(password2)) throw new PassMismatchException();
        System.out.println("email"+email);
        System.out.println("pass"+password);
        System.out.println("pass2"+password2);
        customerRepo.findCustomerByEmail(email).orElseThrow(EmailIsUsedException::new);

        Customer customer = new Customer(name, surname, email, passwordEncoder.encode(password));
        customerRepo.save(customer);
    }


    public Optional<Customer> findUserForLogin(String email) {
        return customerRepo.findCustomerByEmail(email);
    }
}
