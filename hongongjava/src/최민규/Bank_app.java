package 최민규;

import java.util.Scanner;

public class Bank_app {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Account[] accounts = new Account[100];
		int select = 0;
		int count = 0;
		for (int i = 0 ; i < 100 ; i++) {
			accounts[i] = new Account();
		}

		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금");
			System.out.println("4. 출금 | 5. 계정 삭제 | 6. 종료");
			System.out.println("---------------------------------------");
			System.out.print("선택 : ");
			select = Integer.parseInt(scanner.nextLine());

			if (select == 1) {
				System.out.println("----------");
				System.out.println("계좌 생성");
				System.out.println("----------");
				System.out.print("계좌 번호 : ");
				String account_num;
				int continue_count = 0;
				account_num = scanner.nextLine();
				for (int i = 0; i < count; i++) {
					if (account_num.equals(accounts[i].get_ano())) {
						System.out.println("중복된 계좌번호가 이미 존재합니다. 처음으로 돌아갑니다.");
						continue_count = 1;;
						break;
					}
				}
				if (continue_count == 1) {
					continue;
				}
				accounts[count].set_ano(account_num);
				System.out.print("계좌 주 : ");
				accounts[count].set_owner(scanner.nextLine());
				System.out.print("초기 입금액 : ");
				int input_money = Integer.parseInt(scanner.nextLine());
				if (input_money < 0) {
					System.out.println("0보다 작은 수를 입력했습니다. 0원으로 저장합니다.");
				}
				accounts[count].set_balence(input_money);
				System.out.println("계좌가 정상적으로 생성되었습니다.");
				count++;
			} else if (select == 2) {
				System.out.println("----------");
				System.out.println("계좌 목록");
				System.out.println("----------");
				for (int i = 0; i < count; i++) {
					System.out.println(
							accounts[i].get_ano() + " | " + accounts[i].get_owner() + " | " + accounts[i].get_balence());
				}
			} else if (select == 3) {
				String account_num;
				int input_money;
				int success = 0;
				System.out.println("----------");
				System.out.println("예금");
				System.out.println("----------");
				System.out.print("계좌 번호 : ");
				account_num = (scanner.nextLine());
				System.out.print("예금액 : ");
				input_money = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < count; i++) {
					if (account_num.equals(accounts[i].get_ano())) {
						accounts[i].set_balence(accounts[i].get_balence() + input_money);
						System.out.println("예금이 정상적으로 완료되었습니다.");
						success = 1;
					}
					if (i + 1 == count && success == 0) {
						System.out.println("계좌 번호를 찾지 못했습니다.");
					}
				}
			} else if (select == 4) {
				String account_num;
				int output_money;
				int success = 0;
				int continue_count = 0;
				System.out.println("----------");
				System.out.println("출금");
				System.out.println("----------");
				System.out.print("계좌 번호 : ");
				account_num = (scanner.nextLine());
				System.out.print("출금액 : ");
				output_money = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < count; i++) {
					if (account_num.equals(accounts[i].get_ano())) {
						if (accounts[i].get_balence() < output_money) {
							System.out.println("잔액이 모자랍니다. 처음 화면으로 돌아갑니다.");
							continue_count = 1;
							break;
						}
						accounts[i].set_balence(accounts[i].get_balence() - output_money);
						success = 1;
						System.out.println("출금이 정상적으로 완료되었습니다.");
					}
					if (i + 1 == count && success == 0) {
						System.out.println("계좌 번호를 찾지 못했습니다.");
					}
				}
				if (continue_count == 1) {
					continue;
				}
			} else if (select == 5) {
				String account_num;
				int find_i = 99;
				int success = 0;
				int continue_count = 0;
				System.out.println("----------");
				System.out.println("계정 삭제");
				System.out.println("----------");
				System.out.print("계좌 번호 : ");
				account_num = (scanner.nextLine());
				for (int i = 0; i < count; i++) {
					if (account_num.equals(accounts[i].get_ano())) {
						find_i = i;
						success = 1;
					}
					if (i + 1 == count && success == 0) {
						System.out.println("계좌 번호를 찾지 못했습니다. 초기 화면으로 돌아갑니다.");
						continue_count = 1;
						break;
					}
				}
				if (continue_count == 1) {
					continue;
				}
				for (int i = find_i; i < count; i++) {
					accounts[i].set_ano(accounts[i + 1].get_ano());
					accounts[i].set_owner(accounts[i + 1].get_owner());
					accounts[i].set_balence(accounts[i + 1].get_balence());
				}
				accounts[count + 1].set_ano(null);
				accounts[count + 1].set_owner(null);
				accounts[count + 1].set_balence(0);
				System.out.println("계좌 삭제를 정상적으로 완료했습니다.");
				count--;
			} else if (select == 6) {
				break;
			}

		}
		scanner.close();
	}

}
