package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.ReportPanel;
import gui.panel.RestorePanel;
import gui.panel.SpendPanel;

public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b=(JButton)e.getSource();
		MainPanel p=MainPanel.instance;
		if(b==p.Bhome){
			p.workingPanel.show(SpendPanel.instence);
		}
		if(b==p.Brecord){
			p.workingPanel.show(RecordPanel.instance);
		}
		if(b==p.Bcategory){
			p.workingPanel.show(CategoryPanel.instance);
		}
		if(b==p.Bchart){
			p.workingPanel.show(ReportPanel.instance);
		}
		if(b==p.Bset){
			p.workingPanel.show(ConfigPanel.instance);
		}
		if(b==p.Bbackup){
			p.workingPanel.show(BackupPanel.instance);
		}
		if(b==p.Brestore){
			p.workingPanel.show(RestorePanel.instance);
		}
	}

}
