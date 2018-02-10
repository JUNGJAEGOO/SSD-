package back12813;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char A[]= in.nextLine().toCharArray();
		char B[]= in.nextLine().toCharArray();
		int res1[] = new int[100000];
		int res2[] = new int[100000];
		int res3[] = new int[100000];
		int res4[] = new int[100000];
		int res5[] = new int[100000];
		int len = 100000;
		for (int i = 0 ; i < len ; i++) {
			int x = Integer.parseInt(String.valueOf(A[i]));
			int y = Integer.parseInt(String.valueOf(B[i]));
			res1[i] = x * y;
			res2[i] = x | y;
			res3[i] = x ^ y;
			res4[i] = 1-x;
			res5[i] = 1-y;
		}
		for (int i = 0 ; i < len ; i++) {
			System.out.print(res1[i]);
		}System.out.println();
		for (int i = 0 ; i < len ; i++) {
			System.out.print(res2[i]);
		}System.out.println();
		for (int i = 0 ; i < len ; i++) {
			System.out.print(res3[i]);
		}System.out.println();
		for (int i = 0 ; i < len ; i++) {
			System.out.print(res4[i]);
		}System.out.println();
		for (int i = 0 ; i < len ; i++) {
			System.out.print(res5[i]);
		}System.out.println();
		
	}
}
