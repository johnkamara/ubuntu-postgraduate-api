package com.preving.intranet.restfulapi.security;

import com.preving.intranet.restfulapi.model.domain.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                null,
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }
}
