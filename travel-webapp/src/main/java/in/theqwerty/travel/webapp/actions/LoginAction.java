package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.user.api.Login;
import in.theqwerty.travel.user.domain.User;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware {
	
	@SuppressWarnings("rawtypes")
	private Map session;
	private String msg;
	private User user;

	private String target;
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}



	@Resource
	private Login login;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		target = (String)session.get("page");
		target = target == null ? "index" : target;
		System.out.println(target);
		user = (User)checkSession("user");
		if(user != null) {
			return user.getRole();
		}
		return LOGIN;
	}
	
	@SuppressWarnings("unchecked")
	public String login() {
		target = (String)session.get("page");
		target = target == null ? "index" : target;
		System.out.println(target);
		if(login.isAuthenticated(user)) {
			session.put("user", user);
			System.out.println("login : put in SESSION");
			System.out.println(user);

			return user.getRole();	
		}
		msg = "*User name or Password does not match";
		
		return INPUT;

	}
	private Object checkSession(final String key) {
		
		if(session.containsKey(key)) {
			return session.get(key);
		}
		return null;
	}
	
	
	public String logout() {
		session.clear();
		return SUCCESS;
	}
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	
}
