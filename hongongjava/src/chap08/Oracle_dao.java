package chap08;

public class Oracle_dao implements Data_access_object{
	@Override
	public void select() {
		System.out.println("Oracle DB select");
	}
	@Override
	public void insert() {
		System.out.println("Oracle DB insert");		
	}
	@Override
	public void update() {
		System.out.println("Oracle DB update");
	}
	@Override
	public void delete() {
		System.out.println("Oracle DB delete");
	}
}
