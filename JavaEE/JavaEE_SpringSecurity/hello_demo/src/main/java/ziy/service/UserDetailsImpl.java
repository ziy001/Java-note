package ziy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/2/10 上午11:19
 * @description TODO:
 * @className MyUserDetails
 */
@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("自定义登录逻辑...");

        if (!Objects.equals(username, "admin")) {
            throw new UsernameNotFoundException("username not found");
        }

        String password = passwordEncoder.encode("root");

        return new User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
