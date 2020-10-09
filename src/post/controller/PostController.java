package post.controller;

import java.util.ArrayList;

import post.dto.People;
import post.dto.PostProject;
import post.dto.Receiver;
import post.dto.Sender;
import post.exception.NotExistException;
import post.service.PostProjectService;
import post.view.EndView;
import post.view.FailView;



public class PostController {
	private static PostController instance = new PostController();
	private static PostProjectService service = PostProjectService.getInstance();

	private PostController() {
	}

	public static PostController getInstance() {
		return instance;
	}

	// 모든 프로젝트 검색
	public void projectListView() {
		ArrayList<PostProject> projectList = service.getAllProjects();
		EndView.projectListView(projectList);
	}

	// 특정 프로젝트 검색
	public void projectSearch(String name)  {
			PostProject project = service.getOneProject(name);
			if(project!=null) { 
			EndView.projectserarchListView(project);
			}else {
			EndView.messageView("검색요청하신 프로젝트는 존재하지 않습니다.");		
			}
	}

	// 새로운 프로젝트 저장
	public void insertProject(PostProject newProject) {
		service.projectInsert(newProject);
	}
	
	// 존재하는 프로젝트 수정
	public void updateProject(String name, People people){
		try {
			service.projectUpdate(name,people);
		}catch(NotExistException e){
			FailView.failMessageView(e.getMessage());
		}
	}

	// 모든 프로젝트 삭제
	public void deleteProject(String name){
		service.projectDelete(name);
	}
	
	// 수신자와 발신자의 가격차이 조회
	public void priceProject(String name){
		PostProject project = service.getOneProject(name);
		EndView.projectpriceListView(project);
	}
	
	//2 경우 중 더 좋은 거래자로 수정
	public void selectProject(String name, People peopleOne, People peopleTwo){
		service.projectSelect(name,peopleOne,peopleTwo);
	}
}

