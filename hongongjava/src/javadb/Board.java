package javadb;

import java.sql.Date;

public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	
	
	public int get_bno() {
		return bno;
	}
	public void set_bno(int bno) {
		this.bno = bno;
	}
	public String get_btitle() {
		return btitle;
	}
	public void set_btitle(String btitle) {
		this.btitle = btitle;
	}
	public String get_bcontent() {
		return bcontent;
	}
	public void set_bcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String get_bwriter() {
		return bwriter;
	}
	public void set_bwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date get_bdate() {
		return bdate;
	}
	public void set_bdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
		return bno + ", " + btitle + ", " + bcontent + ", " + bwriter + ", " + bdate;
	}
}
