package app.security;

import app.entity.Customer;
import app.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j2
@Configuration
@AllArgsConstructor
public class UserrDetailsService implements UserDetailsService {

  private final CustomerService userService;


  public static UserDetails userToUserDetails(Customer customer) {
    return User
            .withUsername(customer.getEmail())
            .password(customer.getPassword())
            .roles()
            .build();
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userService.findUserForLogin(email)
            .map(UserrDetailsService::userToUserDetails).orElseThrow(()-> new UsernameNotFoundException("User not found"));
  }
}
