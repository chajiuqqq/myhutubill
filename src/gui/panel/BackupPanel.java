package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends JPanel implements WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	
	public JButton Bbackup=new JButton("±¸·Ý");
	
	public static BackupPanel instance=new BackupPanel();
	
	private BackupPanel() {
		// TODO Auto-generated constructor stub
		this.add(Bbackup);
		GUIUtil.setColor(ColorUtil.blueColor, Bbackup);
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
}
