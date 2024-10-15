package chap08;

public class Mysql_dao implements Data_access_object{
	@Override
	public void select() {
		System.out.println("Mysql DB select");
	}
	@Override
	public void insert() {
		System.out.println("Mysql DB insert");		
	}
	@Override
	public void update() {
		System.out.println("Mysql DB update");
	}
	@Override
	public void delete() {
		System.out.println("Mysql DB delete");
	}
}
