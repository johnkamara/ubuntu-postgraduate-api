package com.preving.intranet.restfulapi.web.seguridad;

import com.preving.intranet.restfulapi.model.domain.UsuarioMin;
import com.preving.intranet.restfulapi.security.JwtAuthenticationRequest;
import com.preving.intranet.restfulapi.security.JwtTokenUtil;
import com.preving.intranet.restfulapi.security.JwtUser;
import com.preving.intranet.restfulapi.security.service.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@ApiIgnore
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;


    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = this.jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = this.jwtTokenUtil.getTokenFromHeader(request);
        String username = this.jwtTokenUtil.getUsernameFromToken(authToken);

        JwtUser user = (JwtUser)  this.userDetailsService.loadUserByUsername(username);

        if (this.jwtTokenUtil.canTokenBeRefreshed(authToken, user.getLastPasswordResetDate())) {
            String refreshedToken = this.jwtTokenUtil.refreshToken(authToken);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));

        } else {
            return ResponseEntity.badRequest().body(null);

        }
    }

}
