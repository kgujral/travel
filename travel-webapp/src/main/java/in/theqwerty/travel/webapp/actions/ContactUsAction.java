package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.deal.api.ContactUsDao;
import in.theqwerty.travel.deal.domain.ContactUsForm;

import javax.annotation.Resource;


@SuppressWarnings("serial")
public class ContactUsAction extends ActionSupport {
	
	private ContactUsForm contactUsForm;
	
	private String msg;

	@Resource
	private ContactUsDao contactUsDao;
	
	@Override
	public String execute() throws Exception {
		go();
		try {
			contactUsDao.persist(contactUsForm);
		}catch (Exception e) {
			this.msg="Please try again.";
			return ERROR;
		} 
		contactUsForm=new ContactUsForm();
		this.msg="Successfully submitted. We will contact you soon.";
		return SUCCESS;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ContactUsForm getContactUsForm() {
		return contactUsForm;
	}

	public void setContactUsForm(ContactUsForm contactUsForm) {
		this.contactUsForm = contactUsForm;
	}
}
