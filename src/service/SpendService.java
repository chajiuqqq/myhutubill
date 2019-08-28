package service;

import java.util.List;

import dao.ConfigDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
	int ThisMonthSpend;
	int TodaySpend ;
	double AvgSpend;
	int ThisMonthLastMoney;
	double AvgAvailable;
	int DaysToTheEnd;
	
	int percent;
	public SpendService() {
		// TODO Auto-generated constructor stub
		ThisMonthSpend=getThisMonthSpend();
		TodaySpend=getTodaySpend();
		AvgSpend=getAvgSpend();
		ThisMonthLastMoney=getThisMonthLastMoney();
		DaysToTheEnd=getDaysToTheEnd();
		AvgAvailable=getAvgAvailable();

	}
	
	
	public int getThisMonthSpend() {
		List<Record> list=new ReportService().getTotalOfMonth();
		int total=0;
		for(Record x:list){
			total+=x.spend;
		}
		return total;
	}
	
	public int getTodaySpend() {
		Record r=new ReportService().getTotalOfDay(DateUtil.today());
		return r.spend;
	}
	
	public double getAvgSpend() {
		return ThisMonthSpend*1.0/DateUtil.totalDaysOfThisMonth();
	}
	
	public int getThisMonthLastMoney() {
		int budget=Integer.parseInt(ConfigDAO.getByKey("budget").value);
		percent=ThisMonthSpend*100/budget;
		return budget-ThisMonthSpend;
	}
	
	public int getDaysToTheEnd() {
		return DateUtil.lastDaysOfThisMonth();
	}
	
	public double getAvgAvailable() {
		return ThisMonthLastMoney*1.0/DaysToTheEnd;
	}
	
	
	
	public SpendPage toSpendPage() {
		return new SpendPage(ThisMonthSpend, TodaySpend, AvgSpend, ThisMonthLastMoney, AvgAvailable, DaysToTheEnd,percent);
	}
	public static void main(String[] args) {
		SpendService service=new SpendService();
		System.out.println(service.ThisMonthSpend);
	}
}
