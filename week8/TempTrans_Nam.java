package week8;
import java.awt.*;

import javax.swing.*;
import java.util.Scanner;
public class TempTrans extends JFrame implements ActionListener {
	private JButton button;
	private JTextField field1;
	private JLabel label1, label2, label3;
	private int C, F;
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=field1.getText();
			C=Integer.parseInt(s);
			F=(C*9/5)+32;
			label3=new JLabel(""+F);
		}
	}
	public TempTrans() {
		this.setSize(300,200);
		this.setTitle("온도 변환기");
		setLayout(new FlowLayout());
		JPanel panel=new JPanel();
		add(panel);
		label1=new JLabel("섭씨 온도");
		field1=new JTextField(15);
		//Scanner sc=new Scanner(System.in);
		//C=sc.nextInt();
		label2=new JLabel("화씨 온도");
		label3=new JLabel();
		button=new JButton("변환");
		button.addActionListener(new MyListener());
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(label3);
		panel.add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
		TempTrans f=new TempTrans();
		
	}
	
	
	
}

