package entity;

public class Config {
	public int id;
	public String key;
	public String value;
	
	public Config() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Config(int id,String key,String value) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.key=key;
		this.value=value;
	}
	public Config(String key,String value) {
		// TODO Auto-generated constructor stub
		this(0,key,value);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+key+" "+value;
	}
	
	
}
