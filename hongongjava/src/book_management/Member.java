package book_management;

import java.util.Date;

public class Member {
	private String member_id;
	private String password;
	private String member_name;
	private String phone;
	private String responsibility;
	private Date creation_date;
	
	public String get_member_id() {
		return member_id;
	}
	public void set_member_id(String member_id) {
		this.member_id = member_id;
	}
	public String get_password() {
		return password;
	}
	public void set_password(String password) {
		this.password = password;
	}
	public String get_member_name() {
		return member_name;
	}
	public void set_member_name(String member_name) {
		this.member_name = member_name;
	}
	public String get_phone() {
		return phone;
	}
	public void set_phone(String phone) {
		this.phone = phone;
	}
	public String get_responsibility() {
		return responsibility;
	}
	public void set_responsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Date get_creation_date() {
		return creation_date;
	}
	public void set_creation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	@Override
	public String toString() {
		return member_id + ", " + password + ", " + member_name + ", " + phone + ", " + responsibility + ", " + creation_date;
	}
}
