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
@Order(1)
@AllArgsConstructor
public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {

    CustomerDetailsService customerDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        http.antMatcher("/customer/**")
                .authorizeRequests()
                .antMatchers("/", "/signup", "/index", "/images/**", "/css/**", "/js/**", "/sass/**","/fonts/**","/js/**","/vendor.fontawesome-free/**")
                .permitAll()
                .antMatchers("/customer/**").hasRole("CUSTOMER")
                .and()
                .formLogin().loginPage("/customer/login").permitAll()
                .defaultSuccessUrl("/customer/dashboard")
                .failureUrl("/customer/login?error=loginError")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/customer-panel/process-logout")
                .logoutSuccessUrl("/customer-panel/login?logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/customer-panel/accessDenied");
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerDetailsService);
    }
}
