package service;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class ReportService {
	public Record getTotalOfDay(Date date) {
		List<Record> list=RecordDAO.list(date);
		int total=0;
		for(Record x:list){
			total+=x.spend;
		}
		Record r=new Record();
		r.spend=total;
		return r;
	}
	
	public List<Record> getTotalOfMonth() {
		List<Record> list=new ArrayList<Record>();
		Date date=DateUtil.theStartOfMonth();
		long aDayTime=1000*60*60*24;
		for(int i=1;i<=DateUtil.totalDaysOfThisMonth();i++){
			list.add(getTotalOfDay(date));
			date=new Date(date.getTime()+aDayTime);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ReportService service=new ReportService();
		List<Record> list=service.getTotalOfMonth();
		for(Record x:list){
			System.out.println(x);
		}
	}
}
