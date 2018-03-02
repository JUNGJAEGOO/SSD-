package back2896;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		
		double x = in.nextDouble();
		double y = in.nextDouble();
		double z = in.nextDouble();
		
		double t = Math.min(a/x,Math.min(b/y, c/z));
		
		
		System.out.println(a-t*x+" "+(b-t*y)+" "+(c-t*z));
		
	}
}
