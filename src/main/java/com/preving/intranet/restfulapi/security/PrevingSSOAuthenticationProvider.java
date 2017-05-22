package com.preving.intranet.restfulapi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by javier-montesinos on 10/05/17.
 */
@Component
public class PrevingSSOAuthenticationProvider implements AuthenticationProvider {

    private static Logger logger = LoggerFactory.getLogger(PrevingSSOAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // use the credentials
        // and authenticate against the third-party system
        boolean authenticated = ("roge".equals(username) && "pwd".equals(password));

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


