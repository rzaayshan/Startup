package app.security;

import app.entity.Seller;
import app.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

@AllArgsConstructor
@Configuration
public class SellerDetailsService implements UserDetailsService {
    private final SellerService sellerService;

    public static UserDetails sellerToSellerDetails(Seller seller){
        HashSet<GrantedAuthority> role = new HashSet<>();
        role.add(new SimpleGrantedAuthority("ROLE_"+seller.getRole()));
        SellerDetails sellerDetails = new SellerDetails(
                seller.getId(),
                seller.getEmail(),
                seller.getPassword(),
                role,
                true,
                true,
                true,
                true
        );
        System.out.println(sellerDetails.getGrantedAuthorities());
        return sellerDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("in seller details servi");
        return sellerService.findSellerByEmail(email)
                .map(s->sellerToSellerDetails(s)).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
