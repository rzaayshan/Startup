//package app.security;
//
//import app.entity.Customer;
//import app.service.CustomerService;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
////@AllArgsConstructor
////@Configuration
////public class CustomerDetailsService implements UserDetailsService {
////    private final CustomerService customerService;
////
////    public static UserDetails customerToCustomerDetails(Customer customer){
////        return User
////                .withUsername(customer.getEmail())
////                .password(customer.getPassword())
////                .roles()
////                .build();
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        return customerService.findUserForLogin(email)
////                .map(CustomerDetailsService::customerToCustomerDetails).orElseThrow(()->new UsernameNotFoundException("User not found"));
////    }
////}
