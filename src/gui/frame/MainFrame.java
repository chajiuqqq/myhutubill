package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame{
	
	
	public static MainFrame instance=new MainFrame();
	private MainFrame() {
		setLocation(300,200);
		setSize(500, 500);
		setResizable(false);
		
		setContentPane(MainPanel.instance);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		MainFrame.instance.setVisible(true);
		
	}
}
