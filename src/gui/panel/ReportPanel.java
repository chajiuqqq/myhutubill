package gui.panel;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends JPanel{
	public static ReportPanel instance=new ReportPanel();
	private ReportPanel() {
		List<Record> list=new ReportService().getTotalOfMonth();
		Image img=ChartUtil.getImage(list,400, 300);
		ImageIcon icon=new ImageIcon(img);
		JLabel label=new JLabel();
		label.setIcon(icon);
		
		this.add(label);
		
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(ReportPanel.instance);
	}
}
