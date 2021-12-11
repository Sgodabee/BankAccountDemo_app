package com.sgodabee.bankaccountsdemo.mailMessenger;

import com.sgodabee.bankaccountsdemo.config.MailConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class MailMessenger {

    public static void htmlEmailMessage(String from, String toMail,String subject, String body) throws MessagingException
    {   //Get Mail Config:
        JavaMailSender sender = MailConfig.getMailConfig();

        //set Mine Message:
        MimeMessage message = sender.createMimeMessage();
        //set mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message,true);

        //set email attributes
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body);

        //send message
        sender.send(message);


    }
}
