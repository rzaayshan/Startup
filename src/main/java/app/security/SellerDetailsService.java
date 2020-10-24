package app.security;

import app.entity.Customer;
import app.entity.Seller;
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
public class SellerDetailsService implements UserDetailsService {
    private final SellerService sellerService;

    public static UserDetails sellerToSellerDetailsX(Seller seller){
        return User
                .withUsername(seller.getCompany())
                .password(seller.getPassword())
                .roles()
                .build();
    }

    public static UserDetails sellerToSellerDetails(Seller seller) {
        return new CustomerDetails(
                seller.getId(),
                seller.getEmail(),
                seller.getPassword(),
                new HashSet<GrantedAuthority>(Collections.singleton
                        (new SimpleGrantedAuthority("ROLE_" + seller.getRole()))),
                true,
                true,
                true,
                true
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return sellerService.findSellerByEmail(email)
                .map(SellerDetailsService::sellerToSellerDetails).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
