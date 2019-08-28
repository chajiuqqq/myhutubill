package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.ColorUtil;
import util.GUIUtil;

public class RestorePanel extends JPanel{
	static{
		GUIUtil.useLNF();
	}
	
	public JButton Brestore=new JButton("»Ö¸´");
	
	public static RestorePanel instance=new RestorePanel();
	
	private RestorePanel() {
		// TODO Auto-generated constructor stub
		this.add(Brestore);
		GUIUtil.setColor(ColorUtil.blueColor, Brestore);
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(RestorePanel.instance);
	}
}
