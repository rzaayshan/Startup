package app.security;

import app.entity.Customer;
import app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
        HashSet<GrantedAuthority> role = new HashSet<>();
        role.add(new SimpleGrantedAuthority("ROLE_"+customer.getRole()));
        CustomerDetails customerDetails = new CustomerDetails(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                role,
                true,
                true,
                true,
                true
        );
        System.out.println(customerDetails.toString());
        System.out.println(customerDetails.getGrantedAuthorities());
        return customerDetails;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.err.println("in load by user");
        System.err.println(email);
        System.err.println(customerService.findCustomerByEmail(email).toString());


        return customerService.findCustomerByEmail(email)
                .map(c->customerToCustomerDetails(c)).orElseThrow(()-> new UsernameNotFoundException("User not found"));


    }
}
