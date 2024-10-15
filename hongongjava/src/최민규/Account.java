package 최민규;

public class Account {
	private String ano;
	private String owner;
	private int balence;
	
	public String get_ano() {
		return ano;
	}
	public void set_ano(String ano) {
		this.ano = ano;
	}
	public String get_owner() {
		return owner;
	}
	public void set_owner(String owner) {
		this.owner = owner;
	}
	public int get_balence() {
		return balence;
	}
	public void set_balence(int balence) {
		if (balence > MAX_BALENCE) {
			balence = MAX_BALENCE;
			System.out.println("최대 입력 한도 초과");
			System.out.println(MAX_BALENCE + "원으로 자동 입력합니다.");
		} else if (balence < MIN_BALENCE) {
			balence = MIN_BALENCE;
			System.out.println("최소 입력 오류");
			System.out.println(MIN_BALENCE + "원으로 자동 입력합니다.");
		}
		this.balence = balence;
	}
	final int MIN_BALENCE = 0;
	final int MAX_BALENCE = 1000000;
}
