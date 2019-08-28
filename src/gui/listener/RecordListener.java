package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.RecordPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RecordPanel p=RecordPanel.instance;
		
		int spend=GUIUtil.toInteger(p.tfSpend);
		Category selectedRecord=(Category)p.cbBox.getSelectedItem();
		String comments= p.tfComments.getText();
		Date date=p.datePicker.getDate();
		
		if(GUIUtil.checkIsZero(p.tfSpend, "spend")){
			JOptionPane.showMessageDialog(null, "金额不能为0！");
			return;
		}
		new RecordService().add(spend,selectedRecord,comments, date);
		p.updateData();
		JOptionPane.showMessageDialog(null, "提交成功！");
	}

}
