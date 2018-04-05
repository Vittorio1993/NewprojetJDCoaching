/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

/**
 *
 * @author zhanghuakai
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    private static void gmailssl(Properties props) {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
// props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.auth", "true");
    }

    public void mail(String mail, String pass) {
        System.out.println("AAAAAAAAAA");
        final String username = "zhanghuakai1234@gmail.com";
        final String password = "zhk061785";

        Properties props = new Properties();

        gmailssl(props);

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

// -- Create a new message --
        Message msg = new MimeMessage(session);

// -- Set the FROM and TO fields --
        try {
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            msg.setSubject("Hello");
            msg.setText("How are you");
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (AddressException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Message sent.");
    }
}


