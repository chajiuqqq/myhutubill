package entity;

import java.util.Date;

public class Record {
	public int id;
	public int spend;
	public int cid;
	public String comments;
	public Date days;
	
	public Record() {
		// TODO Auto-generated constructor stub
	}
	public Record(int id,int spend,int cid,String comments,Date days) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.spend=spend;
		this.cid=cid;
		this.comments=comments;
		this.days=days;
	}
	public Record(int spend,int cid,String comments,Date days) {
		// TODO Auto-generated constructor stub
		this(0, spend, cid, comments, days);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=String.format("id:%s\tspend:%s\tcid:%s\tcomments:%s\tdate:%s", id,spend,cid,comments,days);
		return str;
	}
	
}
