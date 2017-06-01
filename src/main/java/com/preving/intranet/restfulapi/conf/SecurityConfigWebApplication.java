package com.preving.intranet.restfulapi.conf;

import com.google.common.collect.Lists;
import com.preving.intranet.restfulapi.model.domain.User;
import com.preving.intranet.restfulapi.security.JwtAuthenticationEntryPoint;
import com.preving.intranet.restfulapi.security.JwtAuthenticationTokenFilter;
import com.preving.intranet.restfulapi.security.PrevingSSOAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * Created by javier-montesinos on 23/03/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigWebApplication extends WebSecurityConfigurerAdapter {

    private List<User> usuarios;



    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(this.previngSSOAuthenticationProvider);
    }

    @Autowired
    private PrevingSSOAuthenticationProvider previngSSOAuthenticationProvider;


    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // we don't need CSRF because our token is invulnerable
        httpSecurity.csrf().disable()

            .exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler).and()

                // don't create session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

            .authorizeRequests()
                // necesario para aceptar CORS OPTIONS
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

            .antMatchers("/auth/**/*")
                .permitAll()
            .anyRequest()
                .authenticated();

        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }

    @Bean
      public List<User> usuarios() {
        User userPrevenna = new User(new Long(1), "usuarioPrevenna", "Prevenna", "",
                "prevenna@prevenna.es", "pwdPrevenna", true, null);
        User userPreving = new User(new Long(1), "usuarioPreving", "Preving", "",
                        "preving@preving.es", "pwdPreving", true, null);

        return Lists.newArrayList(userPrevenna, userPreving);
      }
}
