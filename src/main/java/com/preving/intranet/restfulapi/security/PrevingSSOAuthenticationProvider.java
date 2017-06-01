package com.preving.intranet.restfulapi.security;

import com.preving.intranet.restfulapi.model.domain.Users;
import com.preving.intranet.restfulapi.model.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by javier-montesinos on 10/05/17.
 */
@Component
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PrevingSSOAuthenticationProvider implements AuthenticationProvider {

    private static Logger logger = LoggerFactory.getLogger(PrevingSSOAuthenticationProvider.class);

    @Autowired
    private Users usuarios;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User usuario = usuarios.getUsuariosList().stream()
                    .filter(e -> e.getUsername().equals(username) && e.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);

        boolean authenticated = usuario != null;

        if (authenticated) {
            return new UsernamePasswordAuthenticationToken(username, password);

        } else {
            return null;
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}


