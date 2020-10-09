package post.dto;


public class Receiver extends People{
	//private String product; // 거래 품목
	private String require; // 수신시 주의 사항
	
	public Receiver() {}
	public Receiver(String require) {
		super();
		this.require =  require;
	}
	public Receiver(String id, String name, int price, String address, String address2, String product, String require) {
		super(id, name, price, address, address2, product);
		//this.product = product;
		this.require = require;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		
		builder.append(", 수신시 주의 사항 : ");
		builder.append(require);		
		builder.append("]");
		return builder.toString();
	}
}
