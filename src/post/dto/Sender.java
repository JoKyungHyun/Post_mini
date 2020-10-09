package post.dto;

public class Sender extends People{
	private String require; // 수신시 주의 사항
	
	public Sender() {}
	public Sender(String require) {
		super();
		this.require =  require;
	}
	public Sender(String id, String name, int price, String address, String address2, String product, String require) {
		super(id, name, price, address, address2, product);
		this.require = require;
	}
	public String getRequire() {
		return require;
	}
	public void setgetRequire(String require) {
		this.require = require;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 발신시 주의 사항 : ");
		builder.append(require);		
		builder.append("]");
		return builder.toString();
	}
}
