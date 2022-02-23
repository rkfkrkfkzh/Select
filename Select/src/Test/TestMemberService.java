package Test;

import java.util.Scanner;

import vo.Professor;
import vo.Student;
import vo.employee;
import vo.member;
import Service.MemberService;
import Service.Service;

public class TestMemberService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = "", name = "", tel = "", addr = "", etc = "";
		int type = 0;
		boolean flag = true;
		int i = 0, j = 0;
		member m = null;
		String[] tag = { "", "school", "dept", "job" };
		Service service = new MemberService();

		while (flag) {

			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.전체출력");
			System.out.println("6.종료");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("그룹선택\n1.학생 2.교수 3.교직원");
				type = sc.nextInt();
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				System.out.println("이름을 입력하세요 :");
				name = sc.next();
				System.out.println("전화번호를 입력하세요 :");
				tel = sc.next();
				System.out.println("주소을 입력하세요 :");
				addr = sc.next();
				System.out.println(tag[type] + "을 입력하세요 :");
				etc = sc.next();
				if (type == 1) {
					service.addMember(new Student(id, name, tel, addr, type,
							etc));
				} else if (type == 2) {
					service.addMember(new Professor(id, name, tel, addr, type,
							etc));
				}else if (type == 3) {
					service.addMember(new employee(id, name, tel, addr, type,
							etc));
				}else{
					System.out.println("입력 오류로 인해 추가되지 않았음");
				}
				break;
			case 2:
				System.out.println("검색할 아이디를 입력하세요 :");
				id = sc.next();
				m= service.getMember(id);
				String str = "";
				if(m.getType()==1){
					str = ((Student)m).toString();
				}else if(m.getType()==2){
					str = ((Professor)m).toString();
				}else if(m.getType()==3){
					str = ((employee)m).toString();
				}
				System.out.println(str);
				break;

			case 3:
				System.out.println("수정할 사람의 id를 입력하세요 : ");
				id = sc.next();
				System.out.println("수정할 전화번호를 입력하세요 :");
				tel = sc.next();
				System.out.println("수정할 주소을 입력하세요 :");
				addr = sc.next();
				m = service.getMember(id);
				type = m.getType();
				System.out.println("수정할 "+tag[type]+"을 입력하세요 :");
				etc = sc.next();
				if (type == 1) {
					service.editMember(new Student(id, "", tel, addr, type,
							etc));
				} else if (type == 2) {
					service.editMember(new Professor(id, "", tel, addr, type,
							etc));
				}else if (type == 3) {
					service.editMember(new employee(id, "", tel, addr, type,
							etc));
				}
				break;

			case 4:
				System.out.println("삭제할 id를 입력하세요 : ");
				id = sc.next();
				service.delMember(id);
				break;

			case 5:
				System.out.println("그룹선택\n1.학생 2.교수 3.교직원");
				type = sc.nextInt();
				System.out.println(service.getMembers(type));
				break;
			case 6:
				flag = false;
				break;

			default:
				System.out.println("잘못 입력했어요 다시 입력하세요 ");
			}

		}

	}

}
