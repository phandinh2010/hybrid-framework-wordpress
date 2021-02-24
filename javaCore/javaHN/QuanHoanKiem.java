package javaHN;

public class QuanHoanKiem {

	// Thuộc tính (Biến/Variable)
	private String district = "Tràng Tiền";

	// Phương thức (Hàm/Method)
	private void setDistrict(String newDistrict) {
		district = newDistrict;
	}

	private String getDistrict() {
		return district;
	}

	public void main(String[] args) {
		// Lấy dữ liệu thông qua biến
		System.out.println(district);

		// Gán dữ liệu thông qua biến
		district = "Chương Dương";

		// Gán dữ liệu thông qua hàm
		setDistrict("Phan Chu Trinh");
		System.out.println(getDistrict());

		setDistrict("Tràng Tiền");
		System.out.println(getDistrict());

		setDistrict("Phan Thị Dinh");
		System.out.println(getDistrict());
	}

	// default
	private String bridge = "Long Bien";

	void setBridge(String bridge) {
		this.bridge = bridge;
	}

	String getBridge() {
		return this.bridge;
	}

	 public String food = "Phở Hà Nội";

	protected void setFood(String food) {
		this.food = food;
	}

	protected String getFood() {
		return this.food;
	}
	
	public static String milk = "Vinamilk";

}