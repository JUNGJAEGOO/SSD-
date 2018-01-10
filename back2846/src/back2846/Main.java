package back2846;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		int end = 0;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		for ( int i = 1 ; i < N ; i++) {
			if ( arr[i] > arr[i-1]) {
				if ( i == N - 1) {
					end = N-1;
					//System.out.println(start+","+end);
					list.add(arr[end]-arr[start]);
				}
			}else {
				end = i-1;
				//System.out.println(start+","+end);
				list.add(arr[end]-arr[start]);
				start = i;
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
}
