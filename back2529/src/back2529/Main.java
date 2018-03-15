package back2529;

import java.util.*;

public class Main {
	static int K;
	static boolean visit[];
	static String process[];
	static ArrayList<String> res = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		K = Integer.parseInt(in.nextLine());
		
		process = in.nextLine().split(" ");
		
		visit = new boolean[10];
		max(0,0,"");
		
		System.out.println(res.get(0));
		System.out.println(res.get(res.size()-1));
	}
	
	public static void max(int len,int now,String go) {
		
		if ( len == K+1) {
			res.add(go);
			return;
		}
		
		if ( len == 0) {
			for ( int i = 9 ; i >= 0 ; i--) {
				if ( visit[i] == false) {
					visit[i] = true;
					max(len+1,i,go+String.valueOf(i));
					visit[i] = false;
				}
			}
		}else {
			for ( int i = 9 ; i >= 0 ; i--) {
				if ( process[len-1].equals(">")) {
					if ( visit[i] == false && i < now) {
						visit[i] = true;
						max(len+1,i,go+String.valueOf(i));
						visit[i] = false;
					}
				}else {
					if ( visit[i] == false && i > now) {
						visit[i] = true;
						max(len+1,i,go+String.valueOf(i));
						visit[i] = false;
					}
				}
			}
		}
	}
	
/*	public static void min(int len,int now,String go) {
		
		if ( len == K+1) {
			System.out.println(go);
			return;
		}
		
		if ( len == 0) {
			for ( int i = 0 ; i <= 9 ; i++) {
				if ( visit[i] == false) {
					visit[i] = true;
					min(len+1,i,go+String.valueOf(i));
					visit[i] = false;
				}
			}
		}else {
			for ( int i = 0 ; i <= 9 ; i++) {
				if ( process[len-1].equals(">")) {
					if ( visit[i] == false && i < now) {
						visit[i] = true;
						min(len+1,i,go+String.valueOf(i));
						visit[i] = false;
					}
				}else {
					if ( visit[i] == false && i > now) {
						visit[i] = true;
						min(len+1,i,go+String.valueOf(i));
						visit[i] = false;
					}
				}
			}
		}
	}*/
}

