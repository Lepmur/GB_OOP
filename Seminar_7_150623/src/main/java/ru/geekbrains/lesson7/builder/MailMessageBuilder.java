package ru.geekbrains.lesson7.builder;

import java.util.Objects;

public class MailMessageBuilder {

    private final MailMessage mailMessage = new MailMessage();

    public MailMessage build(){

        if (mailMessage.getTo() == null || Objects.equals(mailMessage.getTo(), ""))
            throw new RuntimeException("Получатель должен быть указан!");
        return mailMessage;
    }

    public MailMessageBuilder setFrom(String address){
        mailMessage.setFrom(address);
        return this;
    }

    public MailMessageBuilder setTo(String address){
        mailMessage.setTo(address);
        return this;
    }

    public MailMessageBuilder setSubject(String subject){
        mailMessage.setSubject(subject);
        return this;
    }

    public MailMessageBuilder setBody(String body){
        mailMessage.setBody(body);
        return this;
    }

}
