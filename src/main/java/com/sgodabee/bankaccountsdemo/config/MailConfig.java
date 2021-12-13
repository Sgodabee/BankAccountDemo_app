package com.sgodabee.bankaccountsdemo.config;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {
    public static JavaMailSenderImpl getMailConfig()
    {
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();
        Properties prop = emailConfig.getJavaMailProperties();
        prop.put("mail.transport.protocol","smtp");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.debug.","true");

        //set Mail Credentials
        emailConfig.setHost("localhost");
        emailConfig.setPort(25);
        emailConfig.setUsername("no-reply@kryptoncapital.co.za");
        emailConfig.setPassword("password123");


        return emailConfig;

    }
}
