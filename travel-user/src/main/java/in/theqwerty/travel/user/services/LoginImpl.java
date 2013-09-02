package in.theqwerty.travel.user.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import in.theqwerty.travel.user.api.Login;
import in.theqwerty.travel.user.api.UserDao;
import in.theqwerty.travel.user.domain.User;

@Service("login")
public class LoginImpl implements Login {

	@Resource
	private UserDao userDao;
	
	public boolean isAuthenticated(final User user) {
		
		if(user == null || user.getName() == null || user.getPassword() == null) {
			return false;
		}
		final User temp =  userDao.findById(user.getName());
		System.out.println(temp);
		if(temp == null || temp.getPassword().isEmpty()) {
			return false;
		}
		else if(temp.getPassword().equals(user.getPassword())) {
			user.setEmail(temp.getEmail());
			user.setFirstName(temp.getFirstName());
			user.setLastName(temp.getLastName());
			user.setPhoneNumber(temp.getPhoneNumber());
			user.setRole(temp.getRole());
			return true;
		}
		return false;
	}
	

}
