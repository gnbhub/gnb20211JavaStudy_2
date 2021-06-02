import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TempConverter extends JFrame{

	public TempConverter() {
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lab1 = new JLabel("화씨 온도");
		JLabel lab2 = new JLabel("섭씨 온도");
		JTextField f1 = new JTextField(15);
		JTextField f2 = new JTextField(15);
		
		JButton b = new JButton("변환");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ct = f2.getText();	//f2에 입력된 글자를 가져온다
				int c,f;
				if (ct.equals(""))	//f2에 아무것도 입력되지 않는다면
					c = 0;		//c를 0으로 둔다
				else
					c = Integer.parseInt(ct);	//wrapper클래스 이용, ct를 정수로 바꾸어 c에 대입한다
				
				String ft = f1.getText();	//f1에 입력된 글자를 가져온다
				if (ft.equals(""))	//f2에 아무것도 입력되지 않는다면
					f = 0;		//f를 0으로 둔다
				else
					f = Integer.parseInt(ft);	//ft를 정수로 바꾸어 f에 대입한다
				
				
				if(f == 0) {	//f가 0인 경우
					f = (int)(9/5*c+32);	//섭씨온도를 화씨온도로 바꾸어 f에 대입
					f1.setText(Integer.toString(f));	//wrapper클래스 이용, f를 String으로 바꾸어 f1 텍스트로 설정
				}
				else if(c == 0 ) {	//c가 0인 경우
					c = (int)((f-32)*5/9);	//화씨온도를 섭씨온도로 바꾸어 c에 대입
					f2.setText(Integer.toString(c));}	//c를 String으로 바꾸어 f2텍스트로 설정
				}
			});
		
		panel.add(lab1);   panel.add(f1);
		panel.add(lab2);   panel.add(f2);
		panel.add(b);
		
		setSize(280,150);
		setTitle("온도변환기");
		setVisible(true);
	}
	public static void main(String[] args) {
		new TempConverter(); 
		}
}
