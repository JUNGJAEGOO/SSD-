package back1124;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int result = 0;
		double a = System.currentTimeMillis();
		for ( int i = A ; i <= B ; i++) {
			
			if ( func(i) ) { result++; }
		}
		
		double b = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(b-a);
	}
	
	public static boolean func(int x) {
		//int arr[] = new int[x/2];
		//int t = x;
		int count = 2;
		int idx = 0;
		int prime = 0;
		
		while ( x!= 1 ) {
			if ( x%count == 0) {
				//arr[idx] = count;
				x /= count;
				idx++;
				if ( isPrime(count) ) {
					prime++;
				}
			}else {
				count++;
			}
		}
		//for ( int i = 0 ; i < arr.length ; i++) {
		/*if (  arr[i] != 0) {
		System.out.print(arr[i]+" ");}
		}System.out.println();*/
		
		//System.out.print(t+"�϶� �Ҽ��� ��: "+prime);
		if ( isPrime(prime)) {
			//System.out.println(" �Ҽ��� ���� �Ҽ��Դϴ�.");
			return true;
		}
		//System.out.println(" �Ҽ��� ���� �Ҽ��� �ƴմϴ�.");
		return false;
	}
	
	public static boolean isPrime(int x) {
		if ( x == 0 || x == 1 ) {
			return false;
		}
		int count = 2;
		while ( count <= x/2 ) {
			if ( x % count == 0) {
				return false;
			}
			count++;
		}
		
		return true;
	}
}
