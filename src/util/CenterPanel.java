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
 * ������壬����show�������Ծ�����ʾһ����������������Ƿ�����
 * @author Alice
 * @version 2019��8��12��
 */
public class CenterPanel extends JPanel {
	private double rate;
	private boolean strech;
	private JComponent showedComponent=null;
	
	/**
	 * 
	 * @param rate ������ʣ����Ϊ1
	 * @param strech �Ƿ�����
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
			//PreferredSize����ʹ�ò��ֹ�����ʱ��ÿ��������úõ�ƫ�óߴ�
			//size���ǵ�ǰ����ĳߴ�
			Dimension theComponent=showedComponent.getPreferredSize();
			
			if(strech){
				//����ʱ�Լ�������sizeΪָ��ֵ
				showedComponent.setSize((int)(theTank.getWidth()*rate), (int)(theTank.getHeight()*rate));
			}else{
				//��Ȼ������Ϊƫ��ֵ
				showedComponent.setSize(theComponent);
			}
			
			int locx=(int) (theTank.getWidth()/2-showedComponent.getWidth()/2);
			int locy=(int)(theTank.getHeight()/2-showedComponent.getHeight()/2);
			
			showedComponent.setLocation(locx, locy);
			
		}
		
		super.repaint();
	}
	
	public void show(JComponent c) {
		//�Ƴ�c�ϵ�ȫ���������
		Component[] components=getComponents();
		for(Component x:components)
			remove(x);
		//���c
		add(c);
		showedComponent=c;
		
		try {
			WorkingPanel panel=(WorkingPanel)c;
			panel.updateData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//updateUI�����repaint����
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
