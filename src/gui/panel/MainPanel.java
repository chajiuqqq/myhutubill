package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel implements WorkingPanel{
	public JButton Bhome=new JButton();
	public JButton Brecord=new JButton();
	public JButton Bcategory=new JButton();
	public JButton Bchart=new JButton();
	public JButton Bset=new JButton();
	public JButton Bbackup=new JButton();
	public JButton Brestore=new JButton();
	public CenterPanel workingPanel;
	
	static{
		GUIUtil.useLNF();
	}
	
	public static MainPanel instance=new MainPanel();
	
	private MainPanel() {

		GUIUtil.setImageIcon(Bhome, "home.png", "����һ��");
		GUIUtil.setImageIcon(Brecord, "record.png", "��һ��");
		GUIUtil.setImageIcon(Bcategory, "category2.png", "���ѷ���");
		GUIUtil.setImageIcon(Bchart, "report.png", "���ѱ���");
		GUIUtil.setImageIcon(Bset, "config.png", "����");
		GUIUtil.setImageIcon(Bbackup, "backup.png", "����");
		GUIUtil.setImageIcon(Brestore, "restore.png", "��ԭ");
		
		JToolBar tBar=new JToolBar();
		tBar.add(Bhome);
		tBar.add(Brecord);
		tBar.add(Bcategory);
		tBar.add(Bchart);
		tBar.add(Bset);
		tBar.add(Bbackup);
		tBar.add(Brestore);
		tBar.setFloatable(false);
		
		workingPanel=new CenterPanel(0.85);
		
		
		this.setLayout(new BorderLayout());
		this.add(tBar,BorderLayout.NORTH);
		this.add(workingPanel,BorderLayout.CENTER);
		
		addListener();
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance,1);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		ToolBarListener listener=new ToolBarListener();
		Bhome.addActionListener(listener);
		Brecord.addActionListener(listener);
		Bcategory.addActionListener(listener);
		Bchart.addActionListener(listener);
		Bbackup.addActionListener(listener);
		Brestore.addActionListener(listener);
		Bset.addActionListener(listener);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
}
