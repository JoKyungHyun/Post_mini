package post.dto;

public class People {
	private String id; // 프로젝트내 ID
	private String name; // 이름
	private int price; // 나이
	private String address; // 주소
	private String address2; // 상세 주소
	private String product; // 거래 품목
	
	public People() {}
	public People(String id, String name, int price, String address, String address2, String product) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.address = address;
		this.address2 = address2;
		this.product = product;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddres2(String address2) {
		this.address2 = address2;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[아이디 : ");
		builder.append(id);
		builder.append(", 이름 : ");
		builder.append(name);
		builder.append(", 원하는 가격 : ");
		builder.append(price);
		builder.append("원");
		builder.append(", 주소 : ");
		builder.append(address);
		builder.append(" ");
		builder.append(address2);
		builder.append(", 상품 : ");
		builder.append(product);	
		return builder.toString();
	}
	
}

