//package spring.boot.example.springboot2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import lombok.AllArgsConstructor;
//import spring.boot.example.springboot2.service_MVC.LoginService;
//
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@AllArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//    private LoginService loginService;
//	
//	@Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/all")
//                .permitAll()
//                .and().formLogin().loginProcessingUrl("/login").permitAll().and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//        
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder);
//    }
//
//
//}