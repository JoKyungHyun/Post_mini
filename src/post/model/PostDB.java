package post.model;

import java.util.ArrayList;

import post.dto.PostProject;
import post.dto.Receiver;
import post.dto.Sender;

public class PostDB {
	private static PostDB instance = new PostDB();
	private ArrayList<PostProject> projects = new ArrayList<>();
	
	private PostDB() {
		projects.add(new PostProject("핸드폰", "post1",
					new Sender("sender1", "김씨", 280000, "서울시", "성동구...", "핸드폰", "특급"), 
					new Receiver("receiver1", "박씨", 210000, "서울시", "노원구...", "핸드폰", "문앞에 배송"), 
								"롯데"));
		
		projects.add(new PostProject("노트북", "post2",
					new Sender("sender2", "오씨", 520000, "부산시", "남구...", "노트북", "취급 주의"), 
					new Receiver("receiver2", "이씨", 430000, "부천시", "원미구...", "노트북", "경비실에 배송"), 
								"CJ"));
		
		projects.add(new PostProject("신발", "post3",
					new Sender("sender3", "고씨", 330000, "서울시","성북구...", "신발", "빠른 배송"), 
					new Receiver("receiver3", "민씨", 300000, "광주시", "서구...", "신발", "우편함에 배송"), 
								"우체국"));
	}
	public static PostDB getInstance() {
		return instance;
	}
	public ArrayList<PostProject> getProjectList(){
		return projects;
	}
	public void insertProject(PostProject newProject) {
		projects.add(newProject);
	}
}
