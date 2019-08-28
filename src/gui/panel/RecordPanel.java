package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends JPanel implements WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	
	public JLabel Lspend=new JLabel("����");
	public JLabel Lcategory=new JLabel("����");
	public JLabel Lcomments=new JLabel("��ע");
	public JLabel Ldays=new JLabel("����");
	
	public JTextField tfSpend=new JTextField("0");
	
	CategoryComboBoxModel cbBoxModel=new CategoryComboBoxModel();
	public JComboBox cbBox=new JComboBox(cbBoxModel);
	
	public JTextField tfComments=new JTextField();
	public JXDatePicker datePicker=new JXDatePicker(new Date());
	
	public JButton Brecord=new JButton("��һ��");
	
	public static RecordPanel instance=new RecordPanel();
	
	private RecordPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, Brecord);
		
		this.setLayout(new BorderLayout());
		this.add(inputPanel(),BorderLayout.NORTH);
		this.add(submitPanel(),BorderLayout.CENTER);
		addListener();
	}
	
	private JPanel inputPanel() {
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,2,40,40));
		p.add(Lspend);
		p.add(tfSpend);
		p.add(Lcategory);
		p.add(cbBox);
		p.add(Lcomments);
		p.add(tfComments);
		p.add(Ldays);
		p.add(datePicker);
		
		return p;
	}
	private JPanel submitPanel(){
		JPanel p=new JPanel();
		p.add(Brecord);
		return p;
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener listener=new RecordListener();
		Brecord.addActionListener(listener);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		cbBoxModel.menu=new CategoryService().list();
		cbBox.updateUI();
	}
	
	
}
