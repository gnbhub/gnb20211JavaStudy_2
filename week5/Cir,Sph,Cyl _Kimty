package fff;
import java.util.Scanner;
class Radius{
	protected double r;
	public void getR() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름의 길이 : ");
		r = sc.nextDouble();
	}
}

class cir extends Radius{
	public void aa() {
		super.getR(); 
		System.out.print("원의 넓이는 " + Math.PI * r *r + "이고 둘레는" + r * Math.PI *2 + "입니다.");}}


class sph extends Radius{
	public void bb() {
		super.getR(); 
		System.out.print("구의 겉넓이는 " + 4.0*Math.PI * r *r + "이고 부피는" + (4.0/3.0)*Math.PI*r*r*r + "입니다.");}}

class cyl extends Radius{
	public void cc() {
		Scanner sc = new Scanner(System.in);
		super.getR(); 
		System.out.print("높이 : ");
		double h = sc.nextDouble();
		System.out.print("원기둥의 겉넓이는 "+ 2*Math.PI*r*r + 2*Math.PI*r*h + "이고 부피는" + Math.PI*r*r*h + "입니다.");}}


public class dd{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택하시오.(원, 원기둥, 구)");
		String type = sc.next();
		String cir; double r;
		
		if(type.equals("원")) {
			cir A = new cir();
			A.aa();
			}
		if(type.equals("구")) {
		    sph A = new sph();
			A.bb();
			}
		if(type.equals("원기둥")) {
		    cyl A = new cyl();
			A.cc();
			}}}
