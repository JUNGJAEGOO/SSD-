package back4884;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			long G = in.nextLong();
			long T = in.nextLong();
			long A = in.nextLong();
			long D = in.nextLong();
			
			if ( G == -1) {
				break;
			}
			
			
			long zobyul = ( T * ( T - 1) ) / 2;
		
			long bigyo = 1;
			long zobyulpeople = A * G;
			long firstpeople = zobyulpeople + D;
			long sum = zobyul * G;
			while ( true ) {
				if ( bigyo < firstpeople) {
					bigyo *= 2;
				}else {
					break;
				}
			}
			
			long x = bigyo - firstpeople;
			//System.out.println(firstpeople+" "+bigyo);
			bigyo /= 2;
			
			while ( bigyo > 0) {
				sum += bigyo;
				bigyo /= 2;
			}
			
			//System.out.println(sum);
			
			System.out.println(G+"*"+A+"/"+T+"+"+D+"="+sum+"+"+x);
		}
	}
}
