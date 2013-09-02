package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.user.domain.User;


@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {

	
	protected boolean isAuthorized() {
		go();
		User user = (User) checkSession("user");
		if(user != null) {
			if(user.getRole().equals("admin")) {
				return true;
			}
		}
		return false;
	}
	
	private Object checkSession(final String key) {
		
		if(session.containsKey(key)) {
			return session.get(key);
		}
		return null;
	}
}
