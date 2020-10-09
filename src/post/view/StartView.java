package post.view;

import post.controller.PostController;
import post.dto.PostProject;
import post.dto.Receiver;
import post.dto.Sender;

public class StartView {

	public static void main(String[] args) {

		PostController controller = PostController.getInstance();
		// 발신자
		Sender sender4 = new Sender("sender4", "고씨", 230000, "서울시", " 강남구...", "가방", "빠른 배송");
		// 수신자
		Receiver receiver4 = new Receiver("receiver4", "민씨", 200000, "서울시", "종로구...", "가방", "우편함에 배송");
		// 새로운 택배 프로젝트
		PostProject newProject = new PostProject("가방", "post3", sender4, receiver4, "롯데");

		// 모든 프로젝트 검색
		System.out.println("===== 1. 모든 프로젝트 검색  =====");
		controller.projectListView();

		System.out.println();		

		// 새로운 프로젝트 저장
		System.out.println("===== 2. 새로운 프로젝트 저장 및 확인 =====");
		controller.insertProject(newProject);
		controller.projectListView();

		System.out.println();

		// 존재하는 프로젝트 검색
		System.out.println("===== 3. 존재하는 프로젝트 검색 =====");
		controller.projectSearch("신발");

		System.out.println();

		System.out.println("===== 4. 존재하지 않는 프로젝트 검색 - 예외처리 =====");
		controller.projectSearch("책상");
		
		System.out.println();
		
  		// 존재하는 프로젝트 수정
		System.out.println("===== 5. 존재하는 프로젝트 수정 및 확인 =====");
		controller.updateProject("가방", new Receiver("receiver5", "고씨", 230000, "제주시", "용담포구...", "가방", "우편함에 배송"));
		controller.projectSearch("가방");
		
		System.out.println();

		// 존재하지 않는 프로젝트 수정 : 예외 발생
		System.out.println("===== 6. 존재하지 않는 프로잭트 수정 - 예외처리 확인용 =====");
		controller.updateProject("책상", new Receiver("receiver6", "박씨", 220000, "청주시", "청원구...", "가방", "경비실에 배송"));
		
		System.out.println();
		
		// 존재하는 프로젝트 삭제 및 삭제여부 확인
		System.out.println("===== 7. 존재하는 프로젝트 삭제 및 확인 =====");
	    controller.deleteProject("신발");
		controller.projectSearch("신발");
		
		System.out.println();
		
		// 10만원이상 or 상품이 다르면 거래 불가
		System.out.println("===== 8. 가격 차가 10만원이상 or 상품이 다르면 거래 불가  =====");
		controller.updateProject("가방", new Sender("sender5", "고씨", 330000, "서울시", "강서구...", "가방", "빠른 배송"));
		controller.updateProject("노트북", new Receiver("receiver7", "이씨", 120000, "부산시", "해운대구...", "신발", "우편함에 배송"));
		controller.projectSearch("가방");
		controller.projectSearch("노트북");
		
		System.out.println();
		
		// 수신자와 발신자의 가격차이 조회
		System.out.println("===== 9. 수신자와 발신자의 가격차이 조회 =====");
		controller.priceProject("핸드폰");	
		
		System.out.println();
		
		// 2 경우 중 더 좋은 거래자로 수정
		System.out.println("===== 10. 더 좋은 거래자로 수정 =====");
		controller.selectProject("핸드폰", new Sender("sender6", "이씨", 270000, "부산시", "해운대구...", "핸드폰", "특급"), new Sender("sender7", "이씨", 220000, "부산시", "해운대구...", "핸드폰", "특급"));				
		controller.projectSearch("핸드폰");
		
		System.out.println();
	}
}

