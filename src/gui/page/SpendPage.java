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
		VThisMonthSpend="��"+ThisMonthSpend;
		VTodaySpend="��"+TodaySpend;
		VAvgSpend=String.format("��%.1f", AvgSpend);
		VThisMonthLastMoney="��"+ThisMonthLastMoney;
		VAvgAvailable=String.format("��%.1f", AvgAvailable);
		VDaysToTheEnd=DaysToTheEnd+"��";
		this.percent=percent;
		
		if(ThisMonthLastMoney<0)
			over=true;
		else
			over=false;

	}
}
