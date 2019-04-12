package pl.dmcs.mordaka.arkadiusz.app.service;

public interface MailSenderService {

    void sendEmail(String to, String subject, String content);
}
