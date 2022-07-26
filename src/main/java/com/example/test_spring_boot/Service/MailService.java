package com.example.test_spring_boot.Service;

import java.util.List;

public interface MailService {
    public void sendMail(String toAddress, String subject, Object model, String filePath, String content);
    public void resetPassWord( String toAddress, String content,int tokken);
}
