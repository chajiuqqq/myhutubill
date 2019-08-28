package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	static File imageFolder=new File("E:\\project\\myhutubill2\\img");
	
    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 设置按钮图标和文字
     * @param button
     * @param imageName 需包含后缀名
     * @param tip
     */
	public static void setImageIcon(JButton button,String imageName,String tip) {
		ImageIcon icon=new ImageIcon(new File(imageFolder, imageName).getAbsolutePath());
		button.setIcon(icon);
		button.setPreferredSize(new Dimension(61, 81));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setText(tip);
	}
	/**
	 * 设置组件颜色
	 * @param color
	 * @param components
	 */
	public static void setColor(Color color,JComponent...components) {
		for(JComponent x:components){
			x.setForeground(color);
		}
	}
	
	/**
	 * 可视化给的panel
	 * @param p
	 * @param rate
	 */
	public static void showPanel(JPanel p,double rate) {
		JFrame f=new JFrame();
		f.setLocation(200,300);
		f.setSize(500, 400);
		f.setResizable(false);
		CenterPanel panel=new CenterPanel(rate);
		
		f.setContentPane(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		panel.show(p);
	}
	
	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}
	
	public static boolean checkIsEmpty(JTextField tf,String name) {
		String getStr=tf.getText();
		if(getStr.length()==0){
			JOptionPane.showMessageDialog(tf, name+"输入有空！请重新输入！");
			tf.grabFocus();
			return true;
		}
		return false;
	}
	
	public static boolean checkIsNumber(JTextField tf,String name) {
		if(!checkIsEmpty(tf, name)){
			try {
				Double.parseDouble(tf.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(tf, name+"输入不为数字！请重新输入！");
				tf.grabFocus();
				return false;
			}
			return true;
		}
		return false;
	}
	public static boolean checkIsZero(JTextField tf,String name) {
		if(checkIsNumber(tf, name)){
			if(Double.parseDouble(tf.getText())==0.0)
			return true;
		}
		return false;
	}
	
	public static int toInteger(JTextField tf) {
		if(checkIsNumber(tf,"")){
			int num=Integer.parseInt(tf.getText());
			return num;
		}
		return Integer.MIN_VALUE;
	}
	
	
	public static void main(String[] args) {
		showPanel(new MyPanel());
	}
	
	private static class MyPanel extends JPanel{
		JLabel l=new JLabel("add");
		JTextField tf=new JTextField();
		JButton b=new JButton("submit");
		
		public MyPanel() {
			tf.setPreferredSize(new Dimension(100, 30));
			this.add(l);
			this.add(tf);
			this.add(b);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
