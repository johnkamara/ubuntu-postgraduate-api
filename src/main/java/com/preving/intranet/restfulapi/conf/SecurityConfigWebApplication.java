package com.preving.intranet.restfulapi.conf;

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

/**
 * Created by javier-montesinos on 23/03/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigWebApplication extends WebSecurityConfigurerAdapter {

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

            .antMatchers("/auth/**/*").permitAll()

            .antMatchers("/students/**/*").authenticated();

        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}
