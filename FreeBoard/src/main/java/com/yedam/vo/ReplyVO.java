package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int reply_num;
	private String reply;
	private String replyer;
	private int board_num;
	private Date reply_date;
}
