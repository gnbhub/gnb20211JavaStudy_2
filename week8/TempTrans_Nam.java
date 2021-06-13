package week8;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TempTrans extends JFrame{
	JButton bt;
	JLabel C, F, FText;
	JTextField CText;
	int CTemp=0, FTemp=0;
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=CText.getText();
			CTemp=Integer.parseInt(s);
			FTemp=(CTemp*9/5)+32;
			FText.setText(""+FTemp);
		}
	}
	public TempTrans() {
		setLayout(new FlowLayout());
		C=new JLabel("섭씨 온도");
		CText=new JTextField(20);
		
		F=new JLabel("화씨 온도");
		FText=new JLabel(" ");
		bt=new JButton("변환하기");
		bt.addActionListener(new MyListener());
		add(C);	add(CText);	add(F);	add(FText);
		add(bt);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		setTitle("온도 변환기");
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		TempTrans t=new TempTrans();
	}
}
