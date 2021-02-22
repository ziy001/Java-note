package ziy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ziy.handler.MyAuthenticationFailureHandler;
import ziy.handler.MyAuthenticationSuccessHandler;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/2/20 上午9:22
 * @description TODO:
 * @className SecurityConfig
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/toError")
                .failureHandler(new MyAuthenticationFailureHandler("https://www.waasaa.com"))
                //因为只有认证成功后才会跳转toMain，所以toMain不需要放行
//                .successForwardUrl("/toMain")
                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"));

        http.authorizeRequests()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/login.html").permitAll()
                //所用请求都必须认证才能访问
                .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }
}
