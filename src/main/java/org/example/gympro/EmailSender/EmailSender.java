package org.example.gympro.EmailSender;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        final String username = "gymprocompany@gmail.com";
        final String password = "gymprocompany123";

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gymprocompany@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rokiroca6@gmail.com"));
            message.setSubject("Prueba");
            message.setText("Esto es una prueba");

            Transport.send(message);

            System.out.println("¡Correo electrónico enviado exitosamente!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
