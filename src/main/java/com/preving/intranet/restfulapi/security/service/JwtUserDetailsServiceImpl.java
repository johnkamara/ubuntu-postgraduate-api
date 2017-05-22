package com.preving.intranet.restfulapi.security.service;

import com.preving.intranet.restfulapi.model.domain.User;
import com.preving.intranet.restfulapi.security.JwtUserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = new User((long) 1, "roge", "r.gragera@preving.com", "Roge", "Gragera", "pwd", true, null);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No existe ningun usuario con el nombre de usuario: '%s'.", username));

        } else {
            return JwtUserFactory.create(user);

        }
    }
}
