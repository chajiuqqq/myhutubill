package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;
/**
 * 中心面板，利用show方法可以居中显示一个组件，可以设置是否拉伸
 * @author Alice
 * @version 2019年8月12日
 */
public class CenterPanel extends JPanel {
	private double rate;
	private boolean strech;
	private JComponent showedComponent=null;
	
	/**
	 * 
	 * @param rate 拉伸比率，最大为1
	 * @param strech 是否拉伸
	 */
	public CenterPanel(double rate ,boolean strech) {
		// TODO Auto-generated constructor stub
		this.rate=rate;
		this.strech=strech;
		this.setLayout(null);
	}
	
	public CenterPanel(double rate ) {
		// TODO Auto-generated constructor stub
		this(rate, true);
	}
	
	@Override
	public void repaint() {
		if(showedComponent!=null){
			Dimension theTank=this.getSize();
			//PreferredSize是在使用布局管理器时给每个组件设置好的偏好尺寸
			//size就是当前组件的尺寸
			Dimension theComponent=showedComponent.getPreferredSize();
			
			if(strech){
				//拉伸时自己设置其size为指定值
				showedComponent.setSize((int)(theTank.getWidth()*rate), (int)(theTank.getHeight()*rate));
			}else{
				//不然就设置为偏好值
				showedComponent.setSize(theComponent);
			}
			
			int locx=(int) (theTank.getWidth()/2-showedComponent.getWidth()/2);
			int locy=(int)(theTank.getHeight()/2-showedComponent.getHeight()/2);
			
			showedComponent.setLocation(locx, locy);
			
		}
		
		super.repaint();
	}
	
	public void show(JComponent c) {
		//移除c上的全部已有组件
		Component[] components=getComponents();
		for(Component x:components)
			remove(x);
		//添加c
		add(c);
		showedComponent=c;
		
		try {
			WorkingPanel panel=(WorkingPanel)c;
			panel.updateData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//updateUI会调用repaint方法
		this.updateUI();
	}

	
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setLocationRelativeTo(null);
		f.setSize(400, 300);
		
		CenterPanel panel=new CenterPanel(0.85);
		JLabel label=new JLabel("ddd");
		label.setBounds(0, 0, 100, 20);
		f.setContentPane(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		JButton button=new JButton("button");
		panel.add(label);
		panel.show(button);
		
	}
	
}
