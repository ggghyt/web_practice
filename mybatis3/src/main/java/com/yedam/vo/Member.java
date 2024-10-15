package com.yedam.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
	public class Member {
	private String member_id;
	private String password;
	private String member_name;
	private String phone;
	private String responsibility;
	private Date creation_date;
	
}
