package ru.geekbrains.lesson7.builder;

public class Program {

    public static void main(String[] args) {
        MailMessage mailMessage1 = new MailMessage();
        mailMessage1.setFrom("from@gmail.com");
        mailMessage1.setSubject("Hello, my friend!");

        MailMessage mailMessage2 = new MailMessageBuilder()
                .setFrom("from@gmail.com")
                .setSubject("Hello!")
                .setBody("message body.")
                .build();

    }

}
