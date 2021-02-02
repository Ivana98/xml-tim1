package tim1.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private Environment env;

  @Async
  public void posaljiMejl(String email, String subject, String content) throws MailException {

      SimpleMailMessage mail = new SimpleMailMessage();
      mail.setTo(email);
      mail.setFrom(env.getProperty("spring.mail.username"));
      mail.setSubject(subject);
      String text = "Dokumenti se nalaze u prilogu." + content;
      mail.setText(text);
      javaMailSender.send(mail);
  }
}
