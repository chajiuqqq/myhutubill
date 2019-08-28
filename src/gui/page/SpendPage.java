package gui.page;

public class SpendPage {
	public String VThisMonthSpend;
	public String VTodaySpend;
	public String VAvgSpend;
	public String VThisMonthLastMoney;
	public String VAvgAvailable;
	public String VDaysToTheEnd;
	public int percent;
	public boolean over;
	public SpendPage(int ThisMonthSpend,int TodaySpend ,double AvgSpend,int ThisMonthLastMoney,double AvgAvailable,int DaysToTheEnd,int percent) {
		VThisMonthSpend="гд"+ThisMonthSpend;
		VTodaySpend="гд"+TodaySpend;
		VAvgSpend=String.format("гд%.1f", AvgSpend);
		VThisMonthLastMoney="гд"+ThisMonthLastMoney;
		VAvgAvailable=String.format("гд%.1f", AvgAvailable);
		VDaysToTheEnd=DaysToTheEnd+"╠ь";
		this.percent=percent;
		
		if(ThisMonthLastMoney<0)
			over=true;
		else
			over=false;

	}
}
