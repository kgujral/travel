package in.theqwerty.travel.core;

import in.theqwerty.travel.core.services.FormSubmitService;

import org.junit.Before;
import org.junit.Test;

public class FormSubmitServiceTest {
	
	private FormSubmitService formSubmitService;
	
	@Before
	public void setUp(){
		formSubmitService = new FormSubmitService();
	}
	
	@Test
	public void shouldTestPath() {
		formSubmitService.pathChecker();
	}
	
}
