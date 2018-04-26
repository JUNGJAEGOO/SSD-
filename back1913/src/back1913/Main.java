package back1913;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int x = in.nextInt();
		int arr[][] = new int[N][N];
		
		int startX = N/2;
		int startY = N/2;
		int now = 1;
		int cnt = 1;
		int flag = -1;
		int saveX = 0 , saveY = 0;
		
		lop:
		while( true ) {

			for ( int i = 1 ; i <= cnt ; i++) {
				
				
				arr[startX][startY]= now;
				if ( startX+flag*1 > N || startX+flag*1 < 0) {
					//System.out.println(startX+" "+startY+"hi");
					break lop;
				}
				now++;
				startX = startX+flag*1;
			}
			
			for ( int i = 1 ; i <= cnt ; i++) {
				
				
				arr[startX][startY]= now;
				if ( startY+flag*-1 > N || startY+flag*-1 < 0) {
					//System.out.println("hi");
					break lop;
				}
				now++;
				
				startY = startY+flag*-1;
			}

			flag *= -1;
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < N; i++) {
			for ( int j = 0 ; j < N; j++) {
				sb.append(arr[i][j]+" ");
				if ( arr[i][j] == x) {
					saveX = i;
					saveY = j;
				}
			}sb.append("\n");
		}
		
		System.out.print(sb);
		saveX++;
		saveY++;
		
		System.out.print(saveX+" "+saveY);
		
	}
}
