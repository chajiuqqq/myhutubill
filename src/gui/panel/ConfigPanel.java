package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ConfigDAO;
import entity.Config;
import gui.listener.ConfigListener;
import service.ConfigService;
import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends JPanel implements WorkingPanel{
	
	static{
		GUIUtil.useLNF();
	}
	public JLabel Lbudget=new JLabel("本月预算");
	public JTextField tfBudget=new JTextField(500);
	
	public JLabel LMysqlPath=new JLabel("Mysql安装路径");
	public JTextField tfMysqlPath=new JTextField();
	
	public JButton Bupdate=new JButton("更新");
	public static ConfigPanel instance=new ConfigPanel();
	
	private ConfigPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(northPanel(),BorderLayout.NORTH);
		this.add(centerPanel(),BorderLayout.CENTER);
		
		GUIUtil.setColor(ColorUtil.blueColor, Bupdate);
		addListener();
	}
	
	private JPanel northPanel(){
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,1,30,30));
		p.add(Lbudget);
		p.add(tfBudget);
		p.add(LMysqlPath);
		p.add(tfMysqlPath);
		return p;
	}
	private JPanel centerPanel(){
		CenterPanel p=new CenterPanel(1, false);
		Bupdate.setPreferredSize(new Dimension(80, 30));
		p.show(Bupdate);
		return p;
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		ConfigListener listener=new ConfigListener();
		Bupdate.addActionListener(listener);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		Config bConfig=ConfigDAO.getByKey("budget");
		Config pConfig=ConfigDAO.getByKey("mysqlPath");
		if(bConfig!=null){
			tfBudget.setText(bConfig.value);
		}
		if(pConfig!=null){
			tfMysqlPath.setText(pConfig.value);
		}
	}
	
	
	
}
