package back4796;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int cnt = 1;
		while ( true ) {
			int x = in.nextInt(),y = in.nextInt(),z = in.nextInt();
			if ( x== 0 && y == 0 && z == 0) {
				break;
			}
			int sum = 0;
			int mok = z / y;
			z =  z - mok*y;
			sum += mok*x;
			sum += z > y ? x : z; 
			System.out.println("Case "+cnt+": "+sum);
			cnt++;
		}
	}
}
