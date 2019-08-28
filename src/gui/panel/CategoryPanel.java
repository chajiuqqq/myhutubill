package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends JPanel implements WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	public CategoryTableModel cTableModel=new CategoryTableModel();
	public JTable table=new JTable(cTableModel);
	public JButton Badd=new JButton("ÐÂ½¨");
	public JButton Bedit=new JButton("±à¼­");
	public JButton Bdel=new JButton("É¾³ý");
	
	public static CategoryPanel instance=new CategoryPanel();
	
	private CategoryPanel() {
		this.setLayout(new BorderLayout());
		this.add(centerPanel(),BorderLayout.CENTER);
		this.add(southPanel(),BorderLayout.SOUTH);
		
		table.setRowSelectionInterval(0, 0);
		GUIUtil.setColor(ColorUtil.blueColor, Badd,Bedit,Bdel);
		addListener();
	}
	
	private JComponent centerPanel(){
		JScrollPane sc=new JScrollPane(table);
		return sc;
		
	}
	
	private JPanel southPanel(){
		JPanel p=new JPanel();
		p.add(Badd);
		p.add(Bedit);
		p.add(Bdel);
		return p;
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		CategoryListener listener=new CategoryListener();
		Badd.addActionListener(listener);
		Bedit.addActionListener(listener);
		Bdel.addActionListener(listener);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		cTableModel.values=new CategoryService().list();
		table.updateUI();
	}
	
	public Category getSelectedCategory() {
		int row=table.getSelectedRow();
		Category c=cTableModel.values.get(row);
		return c;
	}
}
