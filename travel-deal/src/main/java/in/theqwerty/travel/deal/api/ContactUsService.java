package in.theqwerty.travel.deal.api;

import in.theqwerty.travel.deal.domain.ContactUsForm;


public interface ContactUsService {

	boolean saveFormInDatabase(ContactUsForm contactUsForm);
}
