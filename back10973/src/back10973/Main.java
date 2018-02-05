package back10973;

import java.util.Scanner;

public class Main {
	static int N;
	static int arr[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		perm(0);
	
		
	}
	
	public static void perm(int d) {
		
		if ( d == N) {
			for (int i = 0 ; i < N ; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
		}else {
			for (int i = d ; i < N ; i++) {
				swap(i,d);
				perm(d+1);
				swap(i,d);
			}
		}
		
		
	}
	
	public static void swap(int n,int a) {
		int temp = arr[n];
		arr[n] = arr[a];
		arr[a] = temp;
	}
}
