public class Product {
	
	private String upc = "";
	private String name = "";
	private double wholesalePrice;
	private double retailPrice;
	private int quantity;
	public Product() {
		
	}
	public Product(String upc, String name, double wholesalePrice, double retailPrice, int quantity) {
		super();
		this.upc = upc;
		this.name = name;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.quantity = quantity;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String  toString() {
		return   this.getUpc()+ "  " + this.getName() + "  " + this.getWholesalePrice()+"  " + this.getRetailPrice()+"  " + this.getQuantity();
		
		  }

}