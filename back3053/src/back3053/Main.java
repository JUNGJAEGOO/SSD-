package back3053;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		
		double eu = r * r * Math.PI; 
		double taxi = r * r * 2;
		
		System.out.format("%.6f",eu);
		System.out.println();
		System.out.format("%.6f",taxi);
		
	}
}
