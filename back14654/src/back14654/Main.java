package back14654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		int cons1 = 0;
		int cons2 = 0;
		int ans1 = 0;
		int ans2 = 0;
		char winner = 0;
		// 1 가위 2 바위 3 보
		for ( int i = 0 ; i < N ; i++) {
			if ( i == 0) {
				if ( arr1[i] == 1 && arr2[i] == 2) {
					ans2 = 1;
					cons2 = 1;
					cons1 = 0;
					winner = '2';
				}else if ( arr1[i] == 1 && arr2[i] == 3) {
					ans1 =1;
					cons1 = 1;
					cons2 = 0;
					winner = '1';
				}else if ( arr1[i] == 2 && arr2[i] == 1) {
					ans1 =1;
					cons1 = 1;
					cons2 = 0;
					winner= '1';
				}else if ( arr1[i] == 2 && arr2[i] == 3) {
					ans2 = 1;
					winner = '2';
					cons2 = 1;
					cons1 = 0;
				}else if ( arr1[i] == 3 && arr2[i] == 1) {
					ans2 = 1;
					winner = '2';
					cons2 =1;
					cons1 = 0;
				}else if ( arr1[i] == 3 && arr2[i] == 2) {
					ans1 =1;
					winner = '1';
					cons2 = 0;
					cons1 = 1;
				}
				continue;
			}
			if ( arr1[i] == 1 && arr2[i] == 1 ) {
				if ( winner == '1') {
					winner = '2';
					ans1 = Math.max(ans1, cons1);
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '1';
					ans2 = Math.max(ans2, cons2);
					cons2 = 0;
					cons1 = 1;
				}
			}else if ( arr1[i] == 1 && arr2[i] == 2 ) {
				if ( winner == '1') {
					ans1 = Math.max(ans1, cons1);
					winner = '2';
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '2';
					
					cons2++;
					ans2 = Math.max(ans2, cons2);
					cons1 = 0;
				}
			}else if ( arr1[i] ==1  && arr2[i] == 3 ) {
				if ( winner == '2') {
					ans2 = Math.max(ans2, cons2);
					winner = '1';
					cons2 = 0;
					cons1 = 1;
				}else {
					winner = '1';
					
					cons1++;
					ans1 = Math.max(ans1, cons1);
					cons2 = 0;
				}
			}else if ( arr1[i] ==2 && arr2[i] == 1 ) {
				if ( winner == '2') {
					ans2 = Math.max(ans2, cons2);
					winner = '1';
					cons2 = 0;
					cons1 = 1;
				}else {
					winner = '1';
					
					cons1++;
					ans1 = Math.max(ans1, cons1);
					cons2 = 0;
				}
			}else if ( arr1[i] ==2  && arr2[i] == 2) {
				if ( winner == '1') {
					winner = '2';
					ans1 = Math.max(ans1, cons1);
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '1';
					ans2 = Math.max(ans2, cons2);
					cons2 = 0;
					cons1 = 1;
				}
			}else if ( arr1[i] ==2  && arr2[i] ==3 ) {
				if ( winner == '1') {
					winner = '2';
					ans1 = Math.max(ans1, cons1);
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '2';
					
					cons2++;
					ans2 = Math.max(ans2, cons2);
					cons1 = 0;
				}
			}else if ( arr1[i] ==3  && arr2[i] ==1 ) {
				if ( winner == '1') {
					winner = '2';
					ans1 = Math.max(ans1, cons1);
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '2';
					cons2++;
					ans2 = Math.max(ans2, cons2);
					cons1 = 0;
				}
			}else if ( arr1[i] ==3 && arr2[i] == 2) {
				if ( winner == '2') {
					winner = '1';
					ans2 = Math.max(ans2, cons2);
					cons2 = 0;
					cons1 = 1;
				}else {
					winner = '1';
					cons1++;
					ans1 = Math.max(ans1, cons1);
					cons2 = 0;
				}
			}else if ( arr1[i] ==3 && arr2[i] ==3 ) {
				if ( winner == '1') {
					winner = '2';
					ans1 = Math.max(ans1, cons1);
					cons1 = 0;
					cons2 = 1;
				}else {
					winner = '1';
					ans2 = Math.max(ans2, cons2);
					cons2 = 0;
					cons1 = 1;
				}
			}
			
		}
		
		System.out.println(Math.max(ans1, ans2));
		
	}
}
