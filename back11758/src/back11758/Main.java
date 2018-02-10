package back11758;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		
		int res = CCW(x1,y1,x2,y2,x3,y3);
		if ( res > 0) {
			System.out.print(1);
		}else if ( res == 0) {
			System.out.print(0);
		}else {
			System.out.print(-1);
		}
	}
	
	public static int CCW(int x1,int y1,int x2,int y2,int x3,int y3) {
		
		int temp = x1*y2 + x2*y3 + x3*y1;
		temp = temp - y1*x2 - y2*x3 - y3*x1;
		
		return temp;
	}
}
