package post.view;

import java.util.ArrayList;
import post.dto.PostProject;



public class EndView {
	
	//특정 프로젝트 출력
	public static void projectserarchListView(PostProject OneProject) {
		System.out.println(OneProject);
	}
		
	//모든 프로젝트 출력
	public static void projectListView(ArrayList<PostProject> allProject) {
		for(int i = 0; i < (allProject.size()); i++) {
			System.out.println("[프로젝트 " +(i+1)+"]");
			System.out.println(allProject.get(i));
			System.out.println();
		}
	}
	
	//예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//가격 차이 와 추천 조정 가격 출력
	public static void projectpriceListView(PostProject OneProject) {
		System.out.println("가격 차이는 " + (OneProject.getSender().getPrice()-OneProject.getReceiver().getPrice()) + "원 입니다");
		System.out.println("추천 조정 가격은  " + (OneProject.getSender().getPrice()+OneProject.getReceiver().getPrice())/2 + "원 입니다");
	}
}
