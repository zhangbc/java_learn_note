package com.runoob;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message.RecipientType;
import java.util.Properties;

/**
 * 发邮件(纯文本，HTML文本，附件)
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:24
 */
public class SendEmail {
    public static void main(String[] args) throws NullPointerException {
        // 收件人邮箱
        String to = "649414754@qq.com";
        // 发件人邮箱
        final String from = "zhangbocheng189@163.com";
        final String pwd = "sxxxxxxxx";
        // 指定发邮件的主机
        String host = "smtp.163.com";
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.host", host);
        properties.put("mail.smtp.auth", "true");

        // 获取默认Session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pwd);
            }
        });

        try {
            // 创建默认的MimeMessage对象
            MimeMessage message = new MimeMessage(session);
            // Set From：头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To：头部头字段
            message.addRecipient(RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject：头部头字段
            message.setSubject("This is the Subject Line!");
            // 设置消息体
            message.setText("This is test text.");
            // 发送HTML消息，可以插入html标签
            message.setContent("<h1>This is actual message</h1>",
                    "text/html;charset=utf-8");
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText("This is message body.");
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            String fileName = "/home/projects/java_pro/java_instances_demo/src/main/java/com/runoob/SendEmail.java";
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            // 发送完整部分
            message.setContent(multipart);
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
