package back2783;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double X = in.nextDouble();
		double Y = in.nextDouble();
		double origin = (X * 1000) / Y;
		ArrayList<Double> p = new ArrayList<>();
		int N = in.nextInt();
		double min = origin;
		for (int i = 0 ; i < N ; i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double res = (x*1000)/y;
			if ( res < min) {
				min = res;
			}
			p.add(res);
		}
		
		System.out.format("%.2f", min);
		
		

	}
	

}
