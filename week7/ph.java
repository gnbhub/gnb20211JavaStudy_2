package rps;
import javax.swing.*;
import java.awt.*;

public class ph extends JFrame{
	public ph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new GridLayout(4,5));
		
		for(int i=0; i<20; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			contentPane.add(button);
			int R = (int)(Math.random()*256);
			int G = (int)(Math.random()*256);
			int B = (int)(Math.random()*256);
			Color color = new Color(R,G,B);
			button.setBackground(color);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ph(); 
		}
}
