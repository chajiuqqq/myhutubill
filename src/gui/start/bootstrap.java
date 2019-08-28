package gui.start;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class bootstrap {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		GUIUtil.useLNF();
		SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instence);
				
			}
		});
	}
	
	
}
