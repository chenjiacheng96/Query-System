package cqh.domain;

public class ProductBean {
	private int pid;
	private String pname;
	private double price;
	private String category_id;
	
	
	@Override
	public String toString() {
		return "ProductBean [pid=" + pid + ", pname=" + pname + ", price=" + price 
				+ ", category_id=" + category_id
				+ "]";
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(int pid, String pname, double price, String category_id) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category_id = category_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	
}
