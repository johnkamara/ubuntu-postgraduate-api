package com.preving.intranet.restfulapi.security;

import com.preving.intranet.restfulapi.model.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by javier-montesinos on 10/05/17.
 */
@Component
public class PrevingSSOAuthenticationProvider implements AuthenticationProvider {

    private static Logger logger = LoggerFactory.getLogger(PrevingSSOAuthenticationProvider.class);

    @Value(value="${seguridad.user}")
    private String seguridadUser;

    @Value(value="${seguridad.pwd}")
    private String seguridadPwd;

    // todo fj2m autowire usuarios usuario, salto, hash.... no guardar la contraseña como texto plano si se puede
    private List<User> usuarios;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // todo fj2m autenticar contra los usuarios guardados en
        boolean authenticated = (seguridadUser.equals(username) && seguridadPwd.equals(password));

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


