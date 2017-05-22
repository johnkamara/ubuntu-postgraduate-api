package com.preving.intranet.restfulapi.conf;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by MiguelMoreno on 21/04/2017.
 */
@Configuration
public class MailConfigApplication {

    @Value("${mail.host}")
    private String mailHost;

    @Value("${mail.port}")
    private int mailPort;

    @Value("${mail.userName}")
    private String mailUserName;

    @Value("${mail.password}")
    private String mailPassword;

    @Bean(name="velocityEngine")
    public VelocityEngine velocityEngine(){
        VelocityEngine velocityEngine=new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        return velocityEngine;
    }

    @Bean(name="javaMailSender")
    public JavaMailSender JavaMailSenderImpl() {
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost(this.mailHost);
        javaMailSenderImpl.setPort(this.mailPort);
        javaMailSenderImpl.setUsername(this.mailUserName);
        javaMailSenderImpl.setPassword(this.mailPassword);
        Properties javaMailProperties=new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailSenderImpl.setJavaMailProperties(javaMailProperties);
        return javaMailSenderImpl;
    }
}
