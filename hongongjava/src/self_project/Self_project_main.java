package self_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Self_project_main {
	static Scanner scanner = new Scanner(System.in);
	static User_info user_info = new User_info();
	static Self_project_dao spd = new Self_project_dao();
	
	// 메인
	public static void main(String[] args) {
		spd.connect();
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 로그인 2. 회원 가입 0. 종료");
		System.out.println("-----------------------------------------------------");
		System.out.print("입력 : ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index == 1) {
			while (true) {
				System.out.print("id : ");
				String id = scanner.nextLine();
			
				System.out.print("pw : ");
				String pw = scanner.nextLine();
			
				user_info = spd.login(id, pw);
				if (user_info.get_user_name() != null) {
					System.out.println("welcome " + user_info.get_user_name() + " ( " + user_info.get_user_position() + " )");
					break;
				}
				if (id.equals("0") && pw.equals("0")) {
					return;
				}
				System.out.println("something error");
				System.out.println("0을 입력하면 종료합니다.");
			}
		} else if (index == 2) {
			System.out.print("ID : ");
			String id = scanner.nextLine();
			user_info.set_user_id(id);
			System.out.print("PW : ");
			String pw = scanner.nextLine();
			user_info.set_user_pw(pw);
			System.out.print("이름 : ");
			String name = scanner.nextLine();
			user_info.set_user_name(name);
			System.out.print("전화번호 : ");
			String phone = scanner.nextLine();
			user_info.set_user_phone(phone);
			System.out.print("주소 : ");
			String addr = scanner.nextLine();
			user_info.set_user_addr(addr);
			spd.insert_user(user_info);
			System.out.println("종료합니다");
			spd.disconnect();
			return;
		} else if (index == 0) {
			System.out.println("종료합니다");
			spd.disconnect();
			return;
		}
		
		if (user_info.get_user_position().equals("guest")) {
			guest_main();
			
		} else if (user_info.get_user_position().equals("admin")) {
			admin_main();
			
			
		}
		
		spd.disconnect();
	}
	// 게스트 메인 페이지
	static void guest_main() {
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1. 상품 구매 2. 문의사항 3. 커뮤니티 4. 내 정보 보기 0. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("입력 : ");
			int index = Integer.parseInt(scanner.nextLine());
			if (index == 1) {
				item_array_list_view();
			} else if (index == 2) {
				inquiry_write();
			} else if (index == 3) {
				community_main();
			} else if (index == 4) {
				user_info_view();
			} else if (index == 0) {
				System.out.println("종료합니다");
				return;
			}
		}
	}
	// 아이템 리스트 5개씩 출력
	static void item_array_list_view() {
		List<Item> list = spd.item_array_list();
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 이름\t\t 재고\t 가격\t\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t", (i % 5) + 1, list.get(i).get_item_name());
				if (list.get(i).get_item_name().length() < 5) {
					System.out.printf("\t");
				}
				System.out.printf(" %d\t %d\t\n", list.get(i).get_item_left(), list.get(i).get_item_price());
			}
			System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" 1 ~ 5 상품 선택");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
			System.out.print("입력 : ");
			String index = scanner.nextLine();
			if (index.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (index.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else {
				int num = Integer.parseInt(index);
				if (num == 0) {
					System.out.println("돌아갑니다");
					break;
				} else if (num < 6 && num > 0) {
					item_view_detail(list, (num + count - 1));
					break;
				}
			}
		}
	}
	// 아이템 상세 보기 + 구매
	static void item_view_detail(List<Item> list, int index) {
		System.out.println(list.get(index).get_item_name() + "  0. 뒤로가기");
		System.out.print("개수 입력 : ");
		int num = Integer.parseInt(scanner.nextLine());
		if (num == 0) {
			return;
		} else {
			spd.buy_item(list.get(index).get_item_num(), list.get(index).get_item_left() - num);
			spd.user_receipt(user_info.get_user_id(), list.get(index).get_item_name(), num);
		}
	}
	// 문의사항 메인 페이지
	static void inquiry_write() {
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 문의 내역 작성 2. 문의 내역 확인 0. 돌아가기");
		System.out.println("-----------------------------------------------------");
		System.out.print("입력 : ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index == 1) {
			System.out.println("-----------------------------------------------------");
			System.out.print("제목 입력 : ");
			String inquiry_title = scanner.nextLine();
			String inquiry_content = "";
			System.out.println("내용 입력 (q을 입력하면 종료) : ");
			while (true) {
				String new_line = scanner.nextLine();
				if (new_line.equals("q")) {
					break;
				}
				inquiry_content = inquiry_content + "\n " + new_line;
			}
			spd.send_inquiry(inquiry_title, inquiry_content, user_info.get_user_id());
			
		} else if (index == 2) {
			inquiry_array_list_view();
		} else if (index == 0) {
			return;
		}
	}
	// 문의사항 5개씩 출력
	static void inquiry_array_list_view() {
		List<Inquiry> list = spd.inquiry_array_list(user_info.get_user_id());
		int count = 0;
		while (true) {
			if (list.size() == 0) {
				System.out.println("문의 내역이 없습니다.");
				return;
			}
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 답변 여부\t 문의 제목\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				String ans = list.get(i).get_inq_answer() == null ? "X" : "O";
				System.out.printf(" %d\t    %s\t %s\n", (i % 5) + 1, ans, list.get(i).get_inq_title());
			}
			System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
			System.out.println("상세보기 (문의 번호 입력)");
			System.out.print("입력 : ");
			String index = scanner.nextLine();
			if (index.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (index.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else {
				int num = Integer.parseInt(index);
				if (num == 0) {
					System.out.println("돌아갑니다");
					break;
				} else if (num < 6 && num > 0) {
					inquiry_view_detail(list, (num + count - 1));
					break;
				}
			}
		}
	}
	// 문의사항 상세 보기
	static void inquiry_view_detail(List<Inquiry> list, int index) {
		System.out.println(list.get(index).get_inq_num() + " : " + list.get(index).get_inq_title());
		System.out.println(list.get(index).get_inq_content());
		
		if (list.get(index).get_inq_answer() == null) {
			System.out.println("현재 등록된 답변이 없습니다.");
		} else {
			System.out.println("답변 : ");
			System.out.println(list.get(index).get_inq_answer());
		}
		
		System.out.print("0 : 메인 화면으로 돌아가기 >> ");
		int num = Integer.parseInt(scanner.nextLine());
		if (num == 0) {
			return;
		}
	}
	// 커뮤니티 메인 페이지 (5개씩 출력)
	static void community_main() {
		List<Community> list = spd.community_array_list(user_info.get_user_id());
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 작성자\t 제목\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comu_title());
			}
			System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 w. 게시글 작성 0. 뒤로가기");
			System.out.println("상세보기 (게시글 번호 입력)");
			System.out.print("입력 : ");
			String index = scanner.nextLine();
			if (index.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (index.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else if (index.equals("w")) {
				System.out.println("-----------------------------------------------------");
				System.out.print("제목 입력 : ");
				String comu_title = scanner.nextLine();
				String comu_content = "";
				System.out.println("내용 입력 (q을 입력하면 종료) : ");
				while (true) {
					String new_line = scanner.nextLine();
					if (new_line.equals("q")) {
						break;
					}
					comu_content = comu_content + "\n " + new_line;
				}
				spd.community_write(comu_title, comu_content, user_info.get_user_id());
				return;
			} else {
				int num = Integer.parseInt(index);
				if (num == 0) {
					System.out.println("돌아갑니다");
					break;
				} else if (num < 6 && num > 0) {
					community_view_detail(list, (num + count - 1));
					break;
				}
			}
		}
	}
	// 커뮤니티 글 상세보기
	static void community_view_detail(List<Community> list, int index) {
		System.out.println("-----------------------------------------------------");
		System.out.println(" " + list.get(index).get_comu_title());
		System.out.println(" 작성자 : " + list.get(index).get_user_id());
		System.out.println(list.get(index).get_comu_content());
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 댓글 보기 0. 메인으로 돌아가기");
		System.out.print("입력 : ");
		int num = Integer.parseInt(scanner.nextLine());
		if (num == 1) {
			comment_view_detail(list.get(index).get_comu_num());
		} else if (num == 0) {
			return;
		}
	}
	// 댓글 확인
	static void comment_view_detail(int index) {
		List<Comments> list = spd.comments_array_list(index);
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 작성자\t 댓글\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comm_content());
			}
			System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 w. 댓글 작성 0. 메인으로 가기");
			System.out.print("입력 : ");
			String num = scanner.nextLine();
			if (num.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (num.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else if (num.equals("w")) {
				System.out.println("-----------------------------------------------------");
				System.out.print("댓글 입력 : ");
				String comm_content = scanner.nextLine();
				spd.comments_write(index, comm_content, user_info.get_user_id());
				return;
			} else if (num.equals("0")) {
				return;
			}
		}
	}
	// 내정보 보기 메인 페이지
	static void user_info_view() {
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 구매 내역 확인 2. 게시글 확인 0. 뒤로가기");
		System.out.println("-----------------------------------------------------");
		System.out.print("입력 : ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index == 1) {
			List<Buy> list = spd.user_buy_list(user_info.get_user_id());
			int count = 0;
			while (true) {
				System.out.println("-----------------------------------------------------");
				System.out.printf(" 번호\t 이름\t\t 구매 수량\t\t 총 가격\t\n");
				for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
					System.out.printf(" %d\t %s\t", (i % 5) + 1, list.get(i).get_item_name());
					if (list.get(i).get_item_name().length() < 5) {
						System.out.printf("\t");
					}
					System.out.printf(" %d\t\t %d\t\n", list.get(i).get_user_buy(), spd.get_single_item_price(list.get(i).get_item_name()) * list.get(i).get_user_buy());
				}
				System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
				System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
				System.out.print("입력 : ");
				String num = scanner.nextLine();
				if (num.equals("p")) {
					if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
						System.out.println("마지막 페이지입니다");
					} else {
						count = count + 5;
					}
				} else if (num.equals("q")) {
					if ((count + 5) / 5 == 1) {
						System.out.println("첫번째 페이지입니다");
					} else {
						count = count - 5;
					}
				} else if (num.equals("0")) {
					return;
				}
			}
		} else if (index == 2) {
			List<Community> list = spd.user_community_list(user_info.get_user_id());
			int count = 0;
			while (true) {
				System.out.println("-----------------------------------------------------");
				System.out.printf(" 번호\t 작성자\t 제목\n");
				for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
					System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comu_title());
				}
				System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
				System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
				System.out.println("상세보기 (게시글 번호 입력)");
				System.out.print("입력 : ");
				String str = scanner.nextLine();
				if (str.equals("p")) {
					if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
						System.out.println("마지막 페이지입니다");
					} else {
						count = count + 5;
					}
				} else if (str.equals("q")) {
					if ((count + 5) / 5 == 1) {
						System.out.println("첫번째 페이지입니다");
					} else {
						count = count - 5;
					}
				} else {
					int num = Integer.parseInt(str);
					if (num == 0) {
						System.out.println("돌아갑니다");
						break;
					} else if (num < 6 && num > 0) {
						community_view_detail(list, (num + count - 1));
						break;
					}
				}
			}
		} else if (index == 0) {
			return;
		}
	}
	
	// 관리자 계정 페이지
	static void admin_main() {
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1. 상품 재고 관리 2. 회원 관리 ");
			System.out.println(" 3. 커뮤니티 관리 4. 문의사항 관리 0. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("입력 : ");
			int index = Integer.parseInt(scanner.nextLine());
			if (index == 1) {
				admin_item_page();
			} else if (index == 2) {
				admin_user_page();
			} else if (index == 3) {
				admin_community_page();
			} else if (index == 4) {
				admin_inquiry_page();
			} else if (index == 0) {
				System.out.println("종료합니다");
				return;
			}
		}
	}
	// 관리자 상품 페이지
	static void admin_item_page() {
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 상품 추가 2. 상품 수정, 삭제 0. 뒤로가기");
		System.out.println("-----------------------------------------------------");
		System.out.print("입력 : ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index == 1) {
			System.out.print("제품 이름 : ");
			String item_name = scanner.nextLine();
			
			System.out.print("제품 설명 (q를 입력하면 종료) : ");
			String item_content = "";
			while (true) {
				String new_line = scanner.nextLine();
				if (new_line.equals("q")) {
					break;
				}
				item_content = item_content + "\n " + new_line;
			}
			System.out.print("입고 수량 : ");
			int item_left = Integer.parseInt(scanner.nextLine());
			System.out.print("개당 가격 : ");
			int item_price = Integer.parseInt(scanner.nextLine());
			spd.insert_item(item_name, item_content, item_left, item_price);
		} else if (index == 2) {
			List<Item> list = spd.item_array_list();
			int count = 0;
			while (true) {
				System.out.println("-----------------------------------------------------");
				System.out.printf(" 번호\t 이름\t\t 재고\t 가격\t\n");
				for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
					System.out.printf(" %d\t %s\t", (i % 5) + 1, list.get(i).get_item_name());
					if (list.get(i).get_item_name().length() < 5) {
						System.out.printf("\t");
					}
					System.out.printf(" %d\t %d\t\n", list.get(i).get_item_left(), list.get(i).get_item_price());
				}
				System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
				System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
				System.out.println(" e. 수정할 항목 선택 d. 삭제할 항목 선택");
				String str = scanner.nextLine();
				if (str.equals("p")) {
					if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
						System.out.println("마지막 페이지입니다");
					} else {
						count = count + 5;
					}
				} else if (str.equals("q")) {
					if ((count + 5) / 5 == 1) {
						System.out.println("첫번째 페이지입니다");
					} else {
						count = count - 5;
					}
				} else if (str.equals("e")) {
					System.out.print("수정할 상품 입력 (1 ~ 5) : ");
					int num = Integer.parseInt(scanner.nextLine());
					if (num == 0) {
						System.out.println("돌아갑니다");
						break;
					} else if (num < 6 && num > 0) {
						update_item_input(list.get((num + count - 1)));
						break;
					}
				} else if (str.equals("d")) {
					System.out.print("삭제할 제품 번호 입력 (1 ~ 5) : ");
					int num = Integer.parseInt(scanner.nextLine());
					if (num == 0) {
						System.out.println("돌아갑니다");
						break;
					} else if (num < 6 && num > 0) {
						spd.delete_item(list.get((num + count - 1)).get_item_num());
						break;
					}
				} else if (str.equals("0")) {
					return;
				}
			}
		} else if (index == 0) {
			return;
		}
	}
	// 관리자 상품 추가 정보 입력
	static void update_item_input(Item item) {
		System.out.println("제품 이름 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		String edit_item_name = scanner.nextLine();
		if (edit_item_name.equals("0")) {
			edit_item_name = item.get_item_name();
		}
		String edit_item_content = "";
		System.out.println("제품 설명 변경 (0을 입력하면 변경 없음, q를 입력하면 종료)");
		System.out.print(" >> ");
		while (true) {
			String new_line = scanner.nextLine();
			if (new_line.equals("q") || new_line.equals("0")) {
				break;
			}
			edit_item_content = edit_item_content + "\n " + new_line;
		}
		if (edit_item_content.equals("")) {
			edit_item_content = item.get_item_content();
		}
		System.out.println("제품 재고 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		int edit_item_left = Integer.parseInt(scanner.nextLine());
		if (edit_item_left == 0) {
			edit_item_left = item.get_item_left();
		}
		System.out.println("제품 가격 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		int edit_item_price = Integer.parseInt(scanner.nextLine());
		if (edit_item_price == 0) {
			edit_item_price = item.get_item_price();
		}

		spd.update_item(edit_item_name, edit_item_content, edit_item_left, edit_item_price, item.get_item_num());
	}
	// 관리자 회원 관리 페이지
	static void admin_user_page() {
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 회원 조회, 수정, 삭제 0. 뒤로가기");
		System.out.println("-----------------------------------------------------");
		System.out.print("입력 : ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index == 1) {
			List<User_info> list = spd.user_array_list();
			int count = 0;
			while (true) {
				System.out.println("-----------------------------------------------------");
				System.out.printf(" 번호\t ID\t PW\t 이름\t 전화번호\t\t 주소\n");
				for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
					System.out.printf(" %d\t %s\t %s\t %s\t", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_user_pw(), list.get(i).get_user_name());
					System.out.printf(" %s\t\t %s\t\n", list.get(i).get_user_phone(), list.get(i).get_user_addr());
				}
				System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
				System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
				System.out.println(" e. 수정할 항목 선택 d. 삭제할 항목 선택");
				String str = scanner.nextLine();
				if (str.equals("p")) {
					if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
						System.out.println("마지막 페이지입니다");
					} else {
						count = count + 5;
					}
				} else if (str.equals("q")) {
					if ((count + 5) / 5 == 1) {
						System.out.println("첫번째 페이지입니다");
					} else {
						count = count - 5;
					}
				} else if (str.equals("e")) {
					System.out.print("수정할 유저 입력 (1 ~ 5) : ");
					int num = Integer.parseInt(scanner.nextLine());
					if (num == 0) {
						System.out.println("돌아갑니다");
						return;
					} else if (num < 6 && num > 0) {
						update_user_input(list.get((num + count - 1)));
						return;
					}
				} else if (str.equals("d")) {
					System.out.print("삭제할 유저 입력 (1 ~ 5) : ");
					int num = Integer.parseInt(scanner.nextLine());
					if (num == 0) {
						System.out.println("돌아갑니다");
						return;
					} else if (num < 6 && num > 0) {
						spd.delete_user_info(list.get((num + count - 1)).get_user_id());
						return;
					}
				} else if (str.equals("0")) {
					return;
				}
			}
		}else if (index == 0) {
			return;
		}
	}
	// 관리자 회원 추가 정보 입력
	static void update_user_input(User_info user_info) {
		System.out.println("유저 PW 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		String edit_user_pw = scanner.nextLine();
		if (edit_user_pw.equals("0")) {
			edit_user_pw = user_info.get_user_pw();
		}
		System.out.println("유저 이름 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		String edit_user_name = scanner.nextLine();
		if (edit_user_name.equals("0")) {
			edit_user_name = user_info.get_user_name();
		}
		System.out.println("유저 전화번호 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		String edit_user_phone = scanner.nextLine();
		if (edit_user_phone.equals("0")) {
			edit_user_phone = user_info.get_user_phone();
		}
		System.out.println("유저 주소 변경 (0을 입력하면 변경 없음)");
		System.out.print(" >> ");
		String edit_user_addr = scanner.nextLine();
		if (edit_user_addr.equals("0")) {
			edit_user_addr = user_info.get_user_addr();
		}
		spd.update_user_info(user_info.get_user_id(), edit_user_pw, edit_user_name, edit_user_phone, edit_user_addr);
	}
	// 관리자 게시판 페이지
	static void admin_community_page() {
		List<Community> list = spd.community_array_list(user_info.get_user_id());
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 작성자\t 제목\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comu_title());
			}
			System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 w. 게시글 작성 0. 뒤로가기");
			System.out.println(" s. 게시글 찾기 d. 게시글 삭제 f. 댓글 찾기");
			System.out.println("상세보기 (게시글 번호 입력)");
			System.out.print("입력 : ");
			String index = scanner.nextLine();
			if (index.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (index.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else if (index.equals("w")) {
				System.out.println("-----------------------------------------------------");
				System.out.print("제목 입력 : ");
				String comu_title = scanner.nextLine();
				String comu_content = "";
				System.out.println("내용 입력 (q을 입력하면 종료) : ");
				while (true) {
					String new_line = scanner.nextLine();
					if (new_line.equals("q")) {
						break;
					}
					comu_content = comu_content + "\n " + new_line;
				}
				spd.community_write(comu_title, comu_content, user_info.get_user_id());
				return;
			} else if (index.equals("s")) {
				System.out.println("-----------------------------------------------------");
				System.out.println(" 1. 제목으로 찾기 2. 내용으로 찾기 3. 글쓴이 찾기 0. 뒤로가기");
				System.out.println("-----------------------------------------------------");
				System.out.print("입력 : ");
				int num = Integer.parseInt(scanner.nextLine());
				List<Community> list_search = new ArrayList<>();
				if (num == 1) {
					System.out.print("제목 입력 : ");
					String input = scanner.nextLine();
					list_search = spd.community_array_search_list(1, input);
					
				} else if (num == 2) {
					System.out.print("내용 입력 : ");
					String input = scanner.nextLine();
					list_search = spd.community_array_search_list(2, input);
					
				} else if (num == 3) {
					System.out.print("글쓴이 입력 : ");
					String input = scanner.nextLine();
					list_search = spd.community_array_search_list(3, input);
					
				} else if (num == 0) {
					return;
				}
				System.out.println("-----------------------------------------------------");
				System.out.printf(" 번호\t 작성자\t 제목\n");
				for (int i = count ; i < ((count + 5) > list_search.size() ? list_search.size() : (count + 5)) ; i++) {
					System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list_search.get(i).get_user_id(), list_search.get(i).get_comu_title());
				}
				System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list_search.size() + 4) / 5) + " )");
				System.out.println(" q. 이전 페이지 p. 다음 페이지 d. 게시글 삭제  0. 뒤로가기");
				System.out.println("상세보기 (게시글 번호 입력)");
				System.out.print("입력 : ");
				index = scanner.nextLine();
				if (index.equals("p")) {
					if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
						System.out.println("마지막 페이지입니다");
					} else {
						count = count + 5;
					}
				} else if (index.equals("q")) {
					if ((count + 5) / 5 == 1) {
						System.out.println("첫번째 페이지입니다");
					} else {
						count = count - 5;
					}
				} else if (index.equals("d")) {
					System.out.println("삭제할 게시글 번호 입력 : ");
					num = Integer.parseInt(scanner.nextLine());
					spd.delete_community(list_search.get((num + count - 1)).get_comu_num());
					return;
				} else {
					num = Integer.parseInt(index);
					if (num == 0) {
						System.out.println("돌아갑니다");
						break;
					} else if (num < 6 && num > 0) {
						admin_community_view_detail(list_search, (num + count - 1));
						break;
					}
				}
			} else if (index.equals("d")) {
				System.out.println("삭제할 게시글 번호 입력 : ");
				int num = Integer.parseInt(scanner.nextLine());
				spd.delete_community(list.get((num + count - 1)).get_comu_num());
				return;
			} else if (index.equals("f")) {
				System.out.println("-----------------------------------------------------");
				System.out.println(" 1. 내용으로 찾기 2. 글쓴이 찾기 0. 뒤로가기");
				System.out.println("-----------------------------------------------------");
				System.out.print("입력 : ");
				int num = Integer.parseInt(scanner.nextLine());
				List<Comments> list_search = new ArrayList<>();
				if (num == 1) {
					System.out.print("내용 입력 : ");
					String input = scanner.nextLine();
					list_search = spd.comments_array_search_list(1, input);
				} else if (num == 2) {
					System.out.print("글쓴이 입력 : ");
					String input = scanner.nextLine();
					list_search = spd.comments_array_search_list(2, input);
				} else if (num == 0) {
					return;
				}
				admin_comment_view_detail(list_search);
				return;
			} else {
				int num = Integer.parseInt(index);
				if (num == 0) {
					System.out.println("돌아갑니다");
					break;
				} else if (num < 6 && num > 0) {
					admin_community_view_detail(list, (num + count - 1));
					break;
				}
			}
		}
	}
	// 관리자 게시판 상세 페이지
	static void admin_community_view_detail(List<Community> list, int index) {
		System.out.println("-----------------------------------------------------");
		System.out.println(" " + list.get(index).get_comu_title());
		System.out.println(" 작성자 : " + list.get(index).get_user_id());
		System.out.println(list.get(index).get_comu_content());
		System.out.println("-----------------------------------------------------");
		System.out.println(" 1. 댓글 보기 2. 삭제하기 0. 메인으로 돌아가기");
		System.out.print("입력 : ");
		int num = Integer.parseInt(scanner.nextLine());
		if (num == 1) {
			admin_comment_view_detail(list.get(index).get_comu_num());
			return;
		} else if (num == 2) {
			spd.delete_community(list.get(index).get_comu_num());
			return;
		} else if (num == 0) {
			return;
		}
	}
	// 관리자 댓글 페이지 (게시글 선택)
	static void admin_comment_view_detail(int index) {
		List<Comments> list = spd.comments_array_list(index);
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 작성자\t 댓글\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comm_content());
			}
			System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 메인으로 가기");
			System.out.println(" w. 댓글 작성 d. 댓글 삭제");
			System.out.print("입력 : ");
			String num = scanner.nextLine();
			if (num.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (num.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else if (num.equals("w")) {
				System.out.println("-----------------------------------------------------");
				System.out.print("댓글 입력 : ");
				String comm_content = scanner.nextLine();
				spd.comments_write(index, comm_content, user_info.get_user_id());
				return;
			} else if (num.equals("d")) {
				System.out.print("삭제할 댓글 번호 입력 : ");
				int idx = Integer.parseInt(scanner.nextLine());
				spd.delete_comments(list.get((idx + count - 1)).get_comm_num());
				return;
			} else if (num.equals("0")) {
				return;
			}
		}
	}
	// 관리자 댓글 페이지 (댓글 검색)
	static void admin_comment_view_detail(List<Comments> list) {
		int count = 0;
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 작성자\t 댓글\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				System.out.printf(" %d\t %s\t %s\n", (i % 5) + 1, list.get(i).get_user_id(), list.get(i).get_comm_content());
			}
			System.out.println("현재 페이지 ( " + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 d. 댓글 삭제 0. 메인으로 가기");
			System.out.print("입력 : ");
			String num = scanner.nextLine();
			if (num.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (num.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else if (num.equals("d")) {
				System.out.print("삭제할 댓글 번호 입력 : ");
				int idx = Integer.parseInt(scanner.nextLine());
				spd.delete_comments(list.get((idx + count - 1)).get_comm_num());
				return;
			} else if (num.equals("0")) {
				return;
			}
		}
	}
	// 관리자 문의 페이지
	static void admin_inquiry_page() {
		List<Inquiry> list = spd.inquiry_array_list();
		int count = 0;
		while (true) {
			if (list.size() == 0) {
				System.out.println("문의 내역이 없습니다.");
				return;
			}
			System.out.println("-----------------------------------------------------");
			System.out.printf(" 번호\t 답변 여부\t 유저 ID\t 문의 제목\n");
			for (int i = count ; i < ((count + 5) > list.size() ? list.size() : (count + 5)) ; i++) {
				String ans = list.get(i).get_inq_answer() == null ? "X" : "O";
				System.out.printf(" %d\t    %s\t %s\t %s\n", (i % 5) + 1, ans, list.get(i).get_user_id(), list.get(i).get_inq_title());
			}
			System.out.println("현재 페이지 (" + ((count + 5) / 5) + " / " + ((list.size() + 4) / 5) + " )");
			System.out.println(" q. 이전 페이지 p. 다음 페이지 0. 뒤로가기");
			System.out.println("상세보기 (문의 번호 입력)");
			System.out.print("입력 : ");
			String index = scanner.nextLine();
			if (index.equals("p")) {
				if ((count + 5) / 5 == ((list.size() + 4) / 5)) {
					System.out.println("마지막 페이지입니다");
				} else {
					count = count + 5;
				}
			} else if (index.equals("q")) {
				if ((count + 5) / 5 == 1) {
					System.out.println("첫번째 페이지입니다");
				} else {
					count = count - 5;
				}
			} else {
				int num = Integer.parseInt(index);
				if (num == 0) {
					System.out.println("돌아갑니다");
					break;
				} else if (num < 6 && num > 0) {
					admin_inquiry_view_detail(list, (num + count - 1));
					break;
				}
			}
		}
	}
	// 관리자 문의 상세 페이지
	static void admin_inquiry_view_detail(List<Inquiry> list, int index) {
		System.out.println(list.get(index).get_inq_num() + " : " + list.get(index).get_inq_title());
		System.out.println(list.get(index).get_inq_content());
		
		if (list.get(index).get_inq_answer() == null) {
			System.out.println("현재 등록된 답변이 없습니다.");
		} else {
			System.out.println("답변 : ");
			System.out.println(list.get(index).get_inq_answer());
		}
		
		System.out.println("1. 답변 작성  2. 문의 내역 삭제 0. 메인으로 가기 ");
		System.out.print(" >> ");
		int num = Integer.parseInt(scanner.nextLine());
		if (num == 1) {
			System.out.println("내용 입력 (q을 입력하면 종료) : ");
			String inq_answer = "";
			while (true) {
				String new_line = scanner.nextLine();
				if (new_line.equals("q")) {
					break;
				}
				inq_answer = inq_answer + "\n " + new_line;
			}
			spd.insert_inq_answer(inq_answer, list.get(index).get_inq_num());
			return;
		} else if (num == 2) {
			spd.delete_inq_answer(list.get(index).get_inq_num());
			return;
		} else if (num == 0) {
			return;
		}
	}
}
