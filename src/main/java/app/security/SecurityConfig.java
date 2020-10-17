package app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

//    @Configuration
//    @Order(1)
    public static class CustomerSecConf extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/", "/signup", "/index", "/images/**", "/css/**", "/js/**", "/sass/**","/fonts/**","/js/**","/vendor.fontawesome-free/**")
                    .permitAll()
                    // log in
                    .and().formLogin().loginPage("/customer/login")
                    .failureUrl("/loginCustomer?error=loginError").defaultSuccessUrl("/customerDashboard")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    // logout
                    .and().logout().logoutUrl("/customer/logout").logoutSuccessUrl("/")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and().exceptionHandling().accessDeniedPage("/403")
                    .and().csrf().disable();
        }
    }

    @Configuration
    @Order(1)
    public static class SellerSecConf extends WebSecurityConfigurerAdapter{
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/", "/signup", "/index", "/images/**", "/css/**", "/js/**", "/sass/**","/fonts/**","/js/**","/vendor.fontawesome-free/**")
                    .permitAll()
                    // log in
                    .and().formLogin().loginPage("/seller/signIn")
                    .failureUrl("/seller/signIn?error=loginError").defaultSuccessUrl("/sellerDashboard")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    // logout
                    .and().logout().logoutUrl("/seller/logout").logoutSuccessUrl("/")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and().exceptionHandling().accessDeniedPage("/403")
                    .and().csrf().disable();
        }
    }
}
