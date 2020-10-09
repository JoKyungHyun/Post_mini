package post.service;

import java.util.ArrayList;

import post.dto.People;
import post.dto.PostProject;
import post.dto.Receiver;
import post.dto.Sender;
import post.exception.NotExistException;
import post.model.PostDB;

public class PostProjectService {
	private static PostProjectService instance = new PostProjectService();
	private PostDB projectVirtualData = PostDB.getInstance();

	private PostProjectService(){}
	public static PostProjectService getInstance(){
		return instance;
	}
	
	// 모든 프로젝트 반환
	public ArrayList<PostProject> getAllProjects(){
		return projectVirtualData.getProjectList();
	}

	// 프로젝트 검색_
	public PostProject getOneProject(String name){
		PostProject project = null;
		ArrayList<PostProject> v = projectVirtualData.getProjectList();
		for(int i = 0; i < v.size(); i++) {
			if(v.get(i).getpProjectName().equals(name)) {
				return v.get(i);
				}
			}
		return project;
	}

	// 새로운 프로젝트 추가
	public void projectInsert(PostProject project) {
		projectVirtualData.insertProject(project);
	}
	
	// 프로젝트 수정 - 프로젝트 명으로 수신자 혹은 발신자 수정_
	public void projectUpdate(String name, People people) throws NotExistException {
		PostProject project = getOneProject(name);
		if(project == null) {
			throw new NotExistException("수정하고 자하는 project가 없습니다.");
		}else if(people instanceof Sender) {
			project.setSender((Sender)people);
		}else if(people instanceof Receiver) {
			project.setReceiver((Receiver)people);
		}else {
			throw new NotExistException("수정형식에 맞지 않습니다.");
		}
	}
	
	// 프로젝트 삭제
	public void projectDelete(String name){
		PostProject project = getOneProject(name);
		projectVirtualData.getProjectList().remove(project);
	}
	
	// 2 경우 중 더 좋은 거래자로 수정(가격 비교를 통하여)
	public void projectSelect(String name, People peopleOne, People peopleTwo){
		PostProject project = getOneProject(name);
		if(peopleOne.getPrice() < peopleTwo.getPrice()){
			if(peopleOne instanceof Sender) {
				project.setSender((Sender)peopleOne);
			}else if(peopleOne instanceof Receiver) {
				project.setReceiver((Receiver)peopleOne);
			}
		}else if(peopleOne.getPrice() > peopleTwo.getPrice()){
			if(peopleTwo instanceof Sender) {
				project.setSender((Sender)peopleTwo);
			}else if(peopleTwo instanceof Receiver) {
				project.setReceiver((Receiver)peopleTwo);
			}
		}
	}
}





