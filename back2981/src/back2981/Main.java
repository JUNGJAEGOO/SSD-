package back2981;

import java.math.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> list;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		list = new ArrayList<>();
		
		for (int i = 0 ; i< N-1 ; i++) {
			list.add(arr[i+1]-arr[i]);
		}
		
		//System.out.println(list);
		int gcd = list.get(0);
		if (list.size() > 1) {
			for ( int i = 1 ; i< list.size() ; i++) {
				gcd = getGCD(gcd,list.get(i));
			}
		}
		//System.out.println(gcd);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2 ; i <= gcd/2 ; i++) {
			if( gcd%i == 0) {
				sb.append(i+" ");
			}
		}
		System.out.print(sb);
		System.out.print(gcd);
		
	}
	
	public static int getGCD(int a,int b) {
		if ( b == 0) {
			return a;
		}else {
			return getGCD(b,a%b);
		}
		
	}
}
