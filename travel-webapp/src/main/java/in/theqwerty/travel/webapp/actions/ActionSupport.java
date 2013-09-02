package in.theqwerty.travel.webapp.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class ActionSupport extends com.opensymphony.xwork2.ActionSupport implements SessionAware {

	protected Map<String, Object> session;

	protected void go() {
		session.put("page", ActionContext.getContext().getName());
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
