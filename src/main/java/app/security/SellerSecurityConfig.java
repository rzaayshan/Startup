package app.security;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(2)
@AllArgsConstructor
public class SellerSecurityConfig extends WebSecurityConfigurerAdapter {

   SellerDetailsService sellerDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        http//.antMatcher("/customer/**")
                .authorizeRequests()
                .antMatchers("/verify","/", "/seller/signUp", "/index", "/images/**", "/css/**", "/js/**", "/sass/**","/fonts/**","/js/**","/vendor/**")
                .permitAll()
                .antMatchers("/seller/**").hasRole("SELLER")
                .and()
                .formLogin().loginPage("/seller-panel/login")
//                .loginProcessingUrl("/customer/process-login")

                .defaultSuccessUrl("/seller/dashboard")
                .failureUrl("/seller-panel/login?error=false")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/seller-panel/process-logout")
                .logoutSuccessUrl("/seller-panel/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/seller-panel/accessDenied");
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.err.println("seller");
        auth.userDetailsService(sellerDetailsService);
    }
}
