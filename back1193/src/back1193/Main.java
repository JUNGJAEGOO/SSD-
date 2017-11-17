package back1193;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner (System.in);
		int N = in.nextInt();
		int n = 1;
		while ( true ) {
			
			int y = 1 + n * ( n - 1) / 2;
			int y2 = 1+ (n+1)*n/2;
			if ( y <= N && N < y2) {
				break;
			}else {
				n++;
			}
		}
		

		int start = 1+n*(n-1)/2;
		int diff = N - start + 1;
		//System.out.println(start);
		if ( n%2 == 0) {
		
		System.out.println(diff+"/"+(n+1-diff));
		}else {
		System.out.println((n+1-diff)+"/"+diff);	
		}
	}
}
