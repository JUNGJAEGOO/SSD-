package back15719;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		
		int N = Integer.parseInt(in.nextLine());
		if ( N == 1) {
			System.out.println(0);
			return;
		}
		
		int arr[] = new int[10000001];
		
		String info[] = in.nextLine().split(" ");
		for ( int i = 0 ; i < N ; i++) {
			int x= Integer.parseInt(info[i]);
			arr[x]++;
			if ( arr[x] > 1) {
				System.out.print(x);
			}
		}
		
	}
}
