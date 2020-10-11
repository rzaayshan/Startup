package app.security;

import app.entity.Seller;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
@Configuration
public class SellerDetailsService implements UserDetailsService {
    private final SellerService sellerService;
    public static UserDetails sellerToSellerDetails(Seller seller){
        return User
                .withUsername(seller.getCompany())
                .password(seller.getPassword())
                .roles()
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String company) throws UsernameNotFoundException {
        return sellerService.findUserForLogin(company)
                .map(SellerDetailsService::sellerToSellerDetails).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
