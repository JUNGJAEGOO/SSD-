package back1222;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[]= new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = 2_000_000;
		
		while ( left<=right) {
			
			int mid = (left+right)>>1;
			int cnt = 0;
			int sum = 0;
			
			for ( int i = 0 ; i < N ; i++) {
				if ( arr[i] >= mid && arr[i]%mid == 0) {
					cnt++;
					sum += arr[i]/mid;
				}
			}
			
		}
	}
}
