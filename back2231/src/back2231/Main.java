package back2231;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int cnt = 1;
		int arr[] = new int[7];
		arr[0] = one(N);
		arr[1] = two(N);
		arr[2] = three(N);
		arr[3] = four(N);
		arr[4] = five(N);
		arr[5] = six(N);
		arr[6] = seven(N);
		for (int x = 0 ; x <7 ; x++) {
			if ( arr[x] != -1) {
				System.out.println(arr[x]);
				return;
			}	
		}
		System.out.println(0);
	}
	
	public static int one(int n){
		int cnt = 1;
		while ( cnt < 10) {
			if ( cnt + cnt%10 == n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int two(int n){
		int cnt = 10;
		while ( cnt < 100) {
			if ( cnt + cnt%10 + cnt/10 == n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int three(int n){
		int cnt = 100;
		while ( cnt < 1000) {
			if ( cnt + cnt%10 + (cnt%100)/10 + cnt/100 == n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int four(int n){
		int cnt = 1000;
		while ( cnt < 10000) {
			if ( cnt + cnt%10 + ((cnt%1000)%100)/10 + (cnt%1000)/100 + cnt/1000== n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int five(int n){
		int cnt = 10000;
		while ( cnt < 100000) {
			if ( cnt + cnt%10 + (((cnt%10000)%1000)%100)/10 + ((cnt%10000)%1000)/100 + (cnt%10000)/1000 + cnt/10000 == n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int six(int n){
		int cnt = 100000;
		while ( cnt < 1000000) {
			if ( cnt + cnt%10 + ((((cnt%100000)%10000)%1000)%100)/10 + (((cnt%100000)%10000)%1000)/100 + ((cnt%100000)%10000)/1000 + (cnt%100000)/10000 + cnt/100000== n) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static int seven(int n){
		int cnt = 1000000;
		
		if ( cnt + cnt%10 + (((((cnt%1000000)%100000)%10000)%1000)%100)/10 + ((((cnt%1000000)%100000)%10000)%1000)/100 + (((cnt%1000000)%100000)%10000)/1000 + ((cnt%1000000)%100000)/10000 + (cnt%1000000)/100000 + cnt/1000000 == n) {
				return cnt;
		}
		
		
		return -1;
	}
}


