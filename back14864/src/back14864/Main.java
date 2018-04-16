package back14864;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int arr[] = new int[N+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = i;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr[a]++;
			arr[b]--;
		}
		
		for ( int i = 1 ; i<= N; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
