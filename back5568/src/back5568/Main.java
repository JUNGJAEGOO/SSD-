package back5568;

import java.util.*;

public class Main {
	static int N,K;
	static int arr[];
	static boolean visit[];
	static ArrayList<String> hm = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		arr = new int[N];
		visit  = new boolean[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		func("",0);
		System.out.println(hm);
		System.out.print(hm.size());
		
	}
	
	public static void func(String now,int len) {
		
		if ( len == K) {
			if ( !hm.contains(now) ) {
				hm.add(now);
			}
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if ( visit[i] == false) {
				visit[i] = true;
				func(now+String.valueOf(arr[i]),len+1);
				visit[i] = false;
			}
		}
		
	}
}
