package back2548;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		//int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//sum += arr[i];
		}
		
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			int now = arr[i];
			
			int summ = 0;
			for ( int j = 0 ; j < N ; j++) {
				summ += Math.abs(arr[j]-now);
			}
			
			if ( summ < min) {
				min = summ;
				list = new ArrayList<>();
				list.add(arr[i]);
			}else if ( summ == min) {
				list.add(arr[i]);
			}
			
		}
		
		Collections.sort(list);
		
		System.out.print(list.get(0));
		
		
	}
}
