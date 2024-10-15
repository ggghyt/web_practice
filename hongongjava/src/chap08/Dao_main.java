package chap08;

public class Dao_main {
	public static void db_work(Data_access_object dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		db_work(new Oracle_dao());
		db_work(new Mysql_dao());
	}

}
