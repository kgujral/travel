package in.theqwerty.travel.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

	@Autowired
	private MailSender mailSender;
	
	@Value("${mailService.username}")
	private String from;
	
    public String getFrom() {
		return from;
	}
    
	public void setFrom(String from) {
		this.from = from;
	}
    
    public void sendMail(String to, String subject, String text, String senderQualifier) {
    	
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom(senderQualifier+"<"+from+">");
        msg.setText(text);
        msg.setSubject(subject);
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            System.err.println(ex.getMessage());            
        }
    }
    
    public void sendMailToMany(String[] to, String subject, String text, String senderQualifier) {
    	
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom(senderQualifier+"<"+from+">");
        msg.setText(text);
        msg.setSubject(subject);
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            System.err.println(ex.getMessage());            
        }
    }

}
