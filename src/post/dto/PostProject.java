package post.dto;

import post.dto.Sender;
import post.dto.Receiver;

public class PostProject {
	private String pProjectName; // 우편프로젝트 이름
	private String pProjectId; // 우편프로젝트 id
	private Sender sender; // 발신자
	private Receiver receiver; // 수신자
	private String postContenent; // 우편 종류
	
	public PostProject() {}
	public PostProject(String pProjectName, String pProjectId, Sender sender, Receiver receiver, String postContenent) {
		this.pProjectName = pProjectName;
		this.pProjectId = pProjectId;
		this.sender = sender;
		this.receiver = receiver;
		this.postContenent = postContenent;
	}
	public String getpProjectName() {
		return pProjectName;
	}
	public void setpProjectName(String pProjectName) {
		this.pProjectName = pProjectName;
	}
	public String getBtProjectId() {
		return pProjectId;
	}
	public void setBtProjectId(String pProjectId) {
		this.pProjectId = pProjectId;
	}
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	public String getPostContenent() {
		return postContenent;
	}
	public void setProjectContenent(String postContenent) {
		this.postContenent = postContenent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[택배 거래 프로젝트 : ");
		builder.append(pProjectName);
		builder.append(", 프로젝트ID : ");
		builder.append(pProjectId);
		builder.append(", 발신자 : ");
		builder.append(sender);
		builder.append(", 수신자 : ");
		builder.append(receiver);
		builder.append(", 택배회사 종류 : ");
		builder.append(postContenent);
		if(sender.getAddress()!=receiver.getAddress()) { // 타 도시로 배달 시 배달료 추가
			builder.append(", 배달료 2000원 추가] ");
		}else
			builder.append(" ]");
		if(sender.getProduct().equals(receiver.getProduct())&&(sender.getPrice()-receiver.getPrice())<100000) { // 상품이 다르거나 가격 차가 10만원 이상일 경우 거래 불가
			return builder.toString();
		}else
			return "거래가 성립되지 않습니다.";
		
	}
}
