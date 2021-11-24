package com.manager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetMailSender {
        @Autowired
        public JavaMailSenderImpl mailSender;

        public  void sendMimeMail(String sid,String mail, String token) {
            try {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);

                messageHelper.setFrom(mailSender.getJavaMailProperties().getProperty("from"));
                messageHelper.setTo(mail);
                messageHelper.setSubject("重置密码!");
                String url = "http://localhost:8081/user/confirmReset?sid="+sid+"&token="+token;
                messageHelper.setText("您正在重置密码，重置链接为："+url);

                mailSender.send(messageHelper.getMimeMessage());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
