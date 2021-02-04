package tim1.email.service;

import java.io.File;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private Environment env;

  @Async
  public void posaljiMejl(String email, String subject, String content) throws Exception {

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(email);
    simpleMailMessage.setFrom(env.getProperty("spring.mail.username"));
    simpleMailMessage.setSubject(subject);

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setFrom(simpleMailMessage.getFrom());
    helper.setTo(simpleMailMessage.getTo());
    helper.setSubject(simpleMailMessage.getSubject());
    helper.setText(content);

    mailSender.send(message);
  }

  @Async
  public void posaljiMejl(String email, String subject, String content, String pdfPath, String htmlPath)
      throws Exception {

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(email);
    simpleMailMessage.setFrom(env.getProperty("spring.mail.username"));
    simpleMailMessage.setSubject(subject);

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setFrom(simpleMailMessage.getFrom());
    helper.setTo(simpleMailMessage.getTo());
    helper.setSubject(simpleMailMessage.getSubject());
    helper.setText( content + "\nDokumenti se nalaze u prilogu ");

    // pdf
    FileSystemResource pdf = new FileSystemResource(pdfPath);
    System.out.println(pdf.exists()); // ovo je provera da li postoji pdf
    helper.addAttachment(pdf.getFilename(), pdf);

    // html
    FileSystemResource xhtml = new FileSystemResource(htmlPath);
    System.out.println(xhtml.exists());
    helper.addAttachment(xhtml.getFilename(), xhtml);
    mailSender.send(message);
  }

}
