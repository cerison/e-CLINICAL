package miu.cs.ads_datapersisitence.service.Impl;

import jakarta.mail.MessagingException;
import miu.cs.ads_datapersisitence.config.EmailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailSenderService {

    public void sendNewMail(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        EmailSender emailSender = new EmailSender(mailSender);

        String recipientEmail = "chernetballa@gmail.com";
        String content = "<p>Hello,</p><p>This is a test email sent from Spring Boot.</p>";

        try {
            emailSender.sendEmail(to, subject, content);
            System.out.println("Email sent successfully.");
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
