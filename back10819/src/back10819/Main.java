package back10819;

import java.util.*;

public class Main {
	static int arr[];
	static boolean visit[];
	static long max = -1;
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		visit = new boolean[N];
		func(new ArrayList<>());
		System.out.println(max);
	}
	
	public static void func(ArrayList<Integer> list) {
		
		//System.out.println(list);
		
		if ( list.size() == N) {
			System.out.print(list);
			long sum = 0;
			for (int i = 0 ; i < list.size()-1 ; i++) {
				sum += Math.abs(list.get(i)-list.get(i+1));
			}
			System.out.println(" "+sum);
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if ( visit[i] == false ) {
				visit[i] = true;
				list.add(arr[i]);
				func(list);
				visit[i] = false;
				list.remove(list.size()-1);
			}
		}
		
	}
}
