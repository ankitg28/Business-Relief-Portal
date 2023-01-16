/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal;

/**
 *
 * @author ankitgoyal
 */
//package utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.mail.Session;

import javax.mail.Session;

import javax.mail.internet.MimeMessage;

import java.util.ArrayList;

public class Mail {

    //SETUP MAIL SERVER PROPERTIES
    //DRAFT AN EMAIL
    //SEND EMAIL
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public void preparetoSendEmail(String emailSubject, String emailBody, String receipent)
            throws MessagingException, AddressException, IOException {
        setupServerProperties();
        draftEmail(emailSubject, emailBody, receipent);
        sendEmail();
    }

    public void preparetoSendEmail(String emailSubject, String emailBody, String receipent, String filepath)
            throws MessagingException, AddressException, IOException {
        // receipent = "ishitajanwale2210@gmail.com";
        setupServerProperties();
        draftEmail(emailSubject, emailBody, receipent, filepath);
        sendEmail();
    }
//	public static void main(String args[]) throws AddressException, MessagingException, IOException
//	{
//		Mail mail = new Mail();
//		mail.setupServerProperties();
//		mail.draftEmail(emailSubject,emailBody,receipent);
//		mail.sendEmail();
//	}

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "ritvik.param@gmail.com";  //Enter sender email id
        String fromUserPassword = "hadwcslwqmtnujax";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    private MimeMessage draftEmail(String emailSubject, String emailBody, String receipent) throws AddressException, MessagingException, IOException {
        ArrayList<String> emailReceipients = new ArrayList<>();
        emailReceipients.add("ankit.28.goyal@gmail.com");
        emailReceipients.add(receipent);
        mimeMessage = new MimeMessage(newSession);

        for (String rec : emailReceipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(rec));
        }
        mimeMessage.setSubject(emailSubject);
//                mimeMessage.setContent(emailBody, "text/html");

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File("/Users/ritvikparamkusham/Documents/GitHub/Business Releif Program/AED_Business_Relief_Program/BusinessReliefPortal/src/Images/AcknowledgmentForm.docx"));

        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        multiPart.addBodyPart(attachmentBodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    private MimeMessage draftEmail(String emailSubject, String emailBody, String receipent, String filepath) throws AddressException, MessagingException, IOException {
        ArrayList<String> emailReceipients = new ArrayList<>();
        emailReceipients.add("ankit.28.goyal@gmail.com");
        emailReceipients.add(receipent);
        mimeMessage = new MimeMessage(newSession);

        for (String rec : emailReceipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(rec));
        }
        mimeMessage.setSubject(emailSubject);
//                mimeMessage.setContent(emailBody, "text/html");

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File(filepath));

        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        multiPart.addBodyPart(attachmentBodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }
}
