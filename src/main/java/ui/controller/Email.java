package ui.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String reciever = request.getParameter("reciever");
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("groep2projectweek2@gmail.com", "bleluyenkxniiprl");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("groep2projectweek2@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            message.setSubject(request.getParameter("subject"));
            message.setText(request.getParameter("message"));
            System.out.println("Sending...");
            Transport.send(message);
            request.setAttribute("success", "Email is succesvol verstuurd");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
            request.setAttribute("error", mex.getMessage());
        }
        request.setAttribute("error", "Email is verstuurd");
        return "emailform.jsp";

    }
    }


