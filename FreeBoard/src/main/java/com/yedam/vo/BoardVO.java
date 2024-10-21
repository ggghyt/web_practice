package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int board_num;
	private String title;
	private String content;
	private String writer;
	private String writer_name;
	private int view_count;
	private Date write_date;
	private Date update_date;
	private String img;
}
