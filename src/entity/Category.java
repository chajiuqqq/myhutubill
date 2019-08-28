package entity;

public class Category {
	public int id;
	public String name;
	public int recordNumber;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String name) {
		// TODO Auto-generated constructor stub
		this(0,name);
	}
	public Category(int id,String name) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+name;
	}
	
	
}
