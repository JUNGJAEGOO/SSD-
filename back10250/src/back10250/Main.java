package back10250;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T >0 ) {
			
			int H = in.nextInt();
			int W = in.nextInt();
			int num = in.nextInt();
			
			int a = num % (H);
			int b =( num-1) / H;
			if ( a== 0) {
				a = H;
			}
			b++;
			
			if ( b >= 10) {
				System.out.println(a+""+b);
			}else if ( b < 10) {
				System.out.println(a+"0"+b);
			}
			T--;
		}
	}
}
