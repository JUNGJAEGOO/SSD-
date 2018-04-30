package back15637;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int info[] = {103,88,91,99,101,86,96,100,71,91,96,91,98,102,96,85,102,97,91,112,85,79,86,91,97,98,110,80,88,80,95,83,93,109,88,91,103,90,95,113,81,86,97,93,93};
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		System.out.print(info[x-1]);
		
	}
}
