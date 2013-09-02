package in.theqwerty.travel.core;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import in.theqwerty.travel.core.services.MailService;

public class MailServiceTest extends AbstractTest {
	
	@Resource
	private MailService mailService;
	
	@Test
	@Ignore
	public void shouldsendMail() {
		mailService.sendMail("desk.theqwerty@gmail.com", "If you are reading this it means your Junit Test worked", "Don't just enjoy and start working on front end :P","Wishes from Trip Exotica");
	}
}
