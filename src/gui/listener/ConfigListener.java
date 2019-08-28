package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String mysqlPath=ConfigPanel.instance.tfMysqlPath.getText();
		String budget=ConfigPanel.instance.tfBudget.getText();
		
		if(!GUIUtil.checkIsNumber(ConfigPanel.instance.tfBudget, "budget")){
			return;
		}
		
		
		File path=new File(mysqlPath);
		if(!mysqlPath.isEmpty()&&!new File(path, "/bin/mysql.exe").exists()){
			JOptionPane.showMessageDialog(ConfigPanel.instance, "mysql路径不正确！");
			return ;
		}
		
		
		new ConfigService().update("budget", budget);
		new ConfigService().update("mysqlPath", mysqlPath);
		
		JOptionPane.showMessageDialog(ConfigPanel.instance, "配置成功！");
		
		
	}
	
	
}
