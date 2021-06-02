package PhoneBook;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookAPP {

	public static void main(String[] args) {
		while(true) {
			System.out.println("***********************************");
			System.out.println("*         전화번호 관리 시스템         *");
			System.out.println("***********************************");
			System.out.println("1.리스트 2.등록. 3.삭제. 4.검색 5.종료");
			System.out.println("-----------------------------------");
			System.out.println("메뉴 번호 > ");
			
			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();
			
			if( id == 1 ) {
				selectAll();
			}else if ( id == 2) {
				InsertPhone();
			}else if ( id == 3) {
				DeletePhone();
			}else if ( id == 4) {
				Search();
			}else if ( id == 5) {
				System.out.println("**********************");
				System.out.println("*       감사합니다      *");
				System.out.println("**********************");
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
		}
	}
	
	private static void selectAll() {
		PhoneDAO dao = new PhoneDAOImpl();
		List<PhoneVO> list = dao.getList();
 
		Iterator<PhoneVO> it = list.iterator();
		while (it.hasNext()) {
			PhoneVO item = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", item.getId(), item.getName(), item.getHp(), item.getTel());
		}
	}
	
	private static void InsertPhone() {
		Scanner scanner = new Scanner(System.in);
				System.out.println(" < 2.등록 > ");
				System.out.print(">이름 : " );
				String Name = scanner.next();
				System.out.print(">휴대전화 : " );;
				String Hp = scanner.next();
				System.out.print(">집전화 : ");
				String Tel = scanner.next();
				
				PhoneVO vo = new PhoneVO(null, Name, Hp, Tel);
				PhoneDAO dao = new PhoneDAOImpl();
				
				boolean success = dao.insert(vo);
				
				System.out.println("[등록되었습니다.]");
				
	}
	private static void DeletePhone() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" < 3.삭제 > ");
		System.out.print( " >번호 : " );
		int id = scanner.nextInt();
		
		PhoneDAO dao = new PhoneDAOImpl();
		boolean success = dao.delete(Long.valueOf(id));
		System.out.println(success ? " [삭제 되었습니다. ] " : " ");
		selectAll();
	}
	private static void Search() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(" < 4. 검색 > ");
		System.out.println(" > 이름 : ");
		String keyword = scanner.next();
		
		PhoneDAO dao = new PhoneDAOImpl();
		List(PhoneVO) list = dao.search(keyword);
		
		Iterator<PhoneVO> it = list.iterator();
		
		while (it.hasNext()) {
			PhoneVO vo = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", vo.getId(),vo.getName(),vo.getHp(),vo.getTel());
			
		}
	}
}