package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;



    @Value("${spring.mail.username}")
    String mailFrom;



    @Override
    public void sendMail(String toAddress, String subject, Object model, String filePath, String content) {

    }

    @Override
    public void resetPassWord(String toAddress, String content, int tokken) {
        try{
            final Context ctx = new Context(LocaleContextHolder.getLocale());
            ctx.setVariable("token", tokken);
            ctx.setVariable("email", toAddress);
            final MimeMessage message = this.javaMailSender.createMimeMessage();
            final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, "UTF-8");
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setFrom(mailFrom);
            mimeMessageHelper.setSubject("Thông báo đăng ký lại mật khẩu");
            String templateHtml = templateEngine.process("mailResetPass", ctx);
            mimeMessageHelper.setText(templateHtml, true);
            this.javaMailSender.send(message);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
