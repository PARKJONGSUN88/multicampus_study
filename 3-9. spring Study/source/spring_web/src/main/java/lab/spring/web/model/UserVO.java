package lab.spring.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserVO {
	 private String userid;
	 @JsonIgnore
	 private String userpwd;
	 private String username;
	 private String email;
	 private String phone;
	 private String address;
	 private String job;
	public String getUserid() {
		return userid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 return "userid:" + getUserid() + "\n" +
        "userpwd:" + getUserpwd() + "\n" +
        "username:" + getUsername() + "\n" +
        "phone:" + getPhone() + "\n" +
        "email:" + getEmail() + "\n" +
        "address:" + getAddress() + "\n" +
        "job:"+ getJob() + "\n";
				
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	 
}
