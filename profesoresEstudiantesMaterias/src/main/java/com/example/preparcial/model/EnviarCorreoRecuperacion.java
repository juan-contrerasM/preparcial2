package com.example.preparcial.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreoRecuperacion {

    public static void main(String[] args) {


        // Configura las propiedades del servidor de correo saliente (SMTP)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Utiliza 465 si habilitaste el uso de SSL
        // Configura las credenciales del remitente
        final String username = "juanj.contrerasm@uqvirtual.edu.co";
        final String password = "1094895197";

        // Configura la sesión de JavaMail
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crea un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("juanj.contrerasm@uqvirtual.edu.co")); // Remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Sara.zambranoo@uqvirtual.edu.co")); // Destinatario
            message.setSubject("Código de recuperación de contraseña"); // Asunto del correo
            String codigoRecuperacion = "123456"; // Genera un código de recuperación de manera adecuada
            message.setText("Tu código de recuperación es: " + 555); // Cuerpo del correo

            // Envía el mensaje
            Transport.send(message);
            System.out.println("Correo electrónico enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

