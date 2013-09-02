package in.theqwerty.travel.deal.services;

import org.springframework.stereotype.Repository;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.deal.api.ContactUsDao;
import in.theqwerty.travel.deal.domain.ContactUsForm;

@Repository("contactUsDao")
public class ContactUsDaoImpl extends GenericDaoImpl<Long, ContactUsForm> implements ContactUsDao{

}
