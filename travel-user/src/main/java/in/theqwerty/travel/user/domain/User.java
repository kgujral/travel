package in.theqwerty.travel.user.domain;

import in.theqwerty.travel.core.util.HashCodeUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	/*
	 * This is the username or login-id
	 */
	@Id
	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	private String firstName;
	
	private String lastName;
	
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(! (obj instanceof User)) {
			return false;
		}
		User temp = (User) obj;
		if( temp.getName().equals(this.getName()) && 
			temp.getPassword().equals(this.getPassword()) &&
			temp.getRole().equals(this.getRole()) ) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, this.name);
		result = HashCodeUtil.hash(result, this.password);
		result = HashCodeUtil.hash(result, this.role);
		return result;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", role=" + role + "]";
	}
	
}
