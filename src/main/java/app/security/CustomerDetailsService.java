package app.security;

import app.entity.Customer;
import app.entity.Seller;
import app.service.CustomerService;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashSet;

@AllArgsConstructor
@Configuration
public class CustomerDetailsService implements UserDetailsService {
    private final CustomerService customerService;

    public static UserDetails customerToCustomerDetailsX(Customer customer){
        return User
                .withUsername(customer.getEmail())
                .password(customer.getPassword())
                .roles()
                .build();
    }

    public static UserDetails customerToCustomerDetails(Customer customer) {
        return new CustomerDetails(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                new HashSet<GrantedAuthority>(Collections.singleton
                        (new SimpleGrantedAuthority("ROLE_" + customer.getRole()))),

                true,
                true,
                true,
                true
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerService.findCustomerByEmail(email)
                .map(CustomerDetailsService::customerToCustomerDetails)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

    }
}
