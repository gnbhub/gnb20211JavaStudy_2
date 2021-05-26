package week7;
import javax.swing.*;
import java.awt.*;
class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		Container contentPane = getContentPane();		
		contentPane.setLayout(new GridLayout(4,5));
		for(int i=0;i<20;i++) {
			String text=Integer.toString(i);
			JButton button=new JButton(text);
			contentPane.add(button);
			int R=(int)(Math.random()*256);
			int G=(int)(Math.random()*256);
			int B=(int)(Math.random()*256);
			Color color=new Color(R, G, B);
			button.setBackground(color);
		}

		setVisible(true);
	}
	
}
public class telephone {
	public static void main(String[] args) {
		MyFrame f=new MyFrame();
		
	}	
}
