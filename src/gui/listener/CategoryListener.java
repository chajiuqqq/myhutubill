package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CategoryPanel c=CategoryPanel.instance;
		if(e.getSource()==c.Badd){
			String key=JOptionPane.showInputDialog("请输入消费类型");
			if(key==null)
				return;
			if(key.isEmpty()){
				JOptionPane.showMessageDialog(null, "类型不能为空");
				return;
			}
			new CategoryService().add(key);
		}
		
		if(e.getSource()==c.Bedit){
			Category category=c.getSelectedCategory();
			String key=JOptionPane.showInputDialog("请输入消费类型");
			if(key==null)
				return;
			if(key.isEmpty()){
				JOptionPane.showMessageDialog(null, "类型不能为空");
				return;
			}
			new CategoryService().update(category.id, key);
		}
		
		if(e.getSource()==c.Bdel){
			Category category=c.getSelectedCategory();
			if(category.recordNumber!=0){
				JOptionPane.showMessageDialog(null, "还有消费记录无法删除该分类！");
				return;
			}
				
			int ans=JOptionPane.showConfirmDialog(null, "确认删除？");
			if(ans==JOptionPane.OK_OPTION)
				new CategoryService().delete(category.id);
		}
		
		JOptionPane.showMessageDialog(null, "操作成功！");
		
		c.updateData();
		
		
	}
	
}
