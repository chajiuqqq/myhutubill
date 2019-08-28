package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends JPanel implements WorkingPanel{
	public JLabel LThisMonthSpend=new JLabel("本月消费");
	public JLabel LTodaySpend=new JLabel("今日消费");
	public JLabel LAvgSpend=new JLabel("日均消费");
	public JLabel LThisMonthLastMoney=new JLabel("本月剩余");
	public JLabel LAvgAvailable=new JLabel("日均可用");
	public JLabel LDaysToTheEnd=new JLabel("距离月末");

	public JLabel VThisMonthSpend=new JLabel("2300");
	public JLabel VTodaySpend=new JLabel("25");
	public JLabel VAvgSpend=new JLabel("125");
	public JLabel VThisMonthLastMoney=new JLabel("2000");
	public JLabel VAvgAvailable=new JLabel("4500");
	public JLabel VDaysToTheEnd=new JLabel("15天");
	public CircleProgressBar bar;
	
	public static SpendPanel instence=new SpendPanel();
	
	private SpendPanel() {
		this.setLayout(new BorderLayout());
		setColor();
		setFont();
		bar=new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		this.add(centerPanel(),BorderLayout.CENTER);
		this.add(southPanel(),BorderLayout.SOUTH);
	}
	
	

	private JPanel centerPanel() {
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		p.add(westPanel(),BorderLayout.WEST);
		p.add(centerPanel2(),BorderLayout.CENTER);
		return p;
		
	}
	private JPanel southPanel() {
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,4));
		p.add(LAvgSpend);
		p.add(LThisMonthLastMoney);
		p.add(LAvgAvailable);
		p.add(LDaysToTheEnd);
		p.add(VAvgSpend);
		p.add(VThisMonthLastMoney);
		p.add(VAvgAvailable);
		p.add(VDaysToTheEnd);
		
		return p;
	}
	
	private JPanel westPanel() {
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,1,20,50));
		p.add(LThisMonthSpend);
		p.add(VThisMonthSpend);
		p.add(LTodaySpend);
		p.add(VTodaySpend);
		p.setPreferredSize(new Dimension(70,100));
		return p;
	}
	private JPanel centerPanel2() {
		
		
		return bar;
	}
	private void setColor() {
		
		GUIUtil.setColor(ColorUtil.blueColor, VThisMonthSpend,VTodaySpend);
		GUIUtil.setColor(ColorUtil.grayColor, LThisMonthSpend,LTodaySpend,LAvgSpend,LThisMonthLastMoney,LAvgAvailable,LDaysToTheEnd,VAvgSpend,VThisMonthLastMoney,VAvgAvailable,VDaysToTheEnd);
	}
	private void setFont() {
		VThisMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 20));
		VTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instence);
	}



	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		SpendPage page=new SpendService().toSpendPage();
		VThisMonthSpend.setText(page.VThisMonthSpend);
		VTodaySpend.setText(page.VTodaySpend);
		VAvgSpend.setText(page.VAvgSpend);
		VThisMonthLastMoney.setText(page.VThisMonthLastMoney);
		VAvgAvailable.setText(page.VAvgAvailable);
		VDaysToTheEnd.setText(page.VDaysToTheEnd);
		
		GUIUtil.setColor(ColorUtil.grayColor, VThisMonthLastMoney,VAvgAvailable);
		
		if(page.over){
			VThisMonthLastMoney.setText("已超支");
			VAvgAvailable.setText("已超支");
			GUIUtil.setColor(ColorUtil.warningColor, VThisMonthLastMoney,VAvgAvailable);
		}
		bar.setProgress(page.percent);
		bar.setForegroundColor(ColorUtil.getByPercentage(page.percent));
	}
	
	
	
}
