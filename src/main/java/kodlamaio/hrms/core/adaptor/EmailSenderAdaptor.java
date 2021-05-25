package kodlamaio.hrms.core.adaptor;

import kodlamaio.hrms.emailVerification.EmailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderAdaptor implements EmailAdaptor {

    @Override
    public boolean sendEmail(String email) {
        EmailSender emailSender = new EmailSender();
        return emailSender.sendEmail(email);
    }
}
