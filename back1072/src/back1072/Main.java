package back1072;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		int Y = in.nextInt();
		double winrate = Y;
		winrate /= X;
		winrate *= 100;
		//System.out.println(winrate);
		int rate = (int) winrate;
		//System.out.println(rate);
		
		int cnt = 0;
		while ( true ) {
			X++;
			Y++;
			cnt++;
			double rating = Y;
			rating /= X;
			rating *= 100;
			//System.out.println(rating);
			if ( (int)rating == rate + 1) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}
