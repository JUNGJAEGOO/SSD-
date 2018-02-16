package back14718;

import java.util.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	static int min = 1000000000;
	static int N,K;
	static int dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		for (int i = 0; i < N ; i++) {
			list.add(new node(in.nextInt(),in.nextInt(),in.nextInt()));
		}
		
		func(0,0,0,0,0,0);
		System.out.println(min);
	}
	
	public static void func(int idx,int win,int sum,int str,int dex,int wise) {
		
		if ( idx == N && win < K) {
			return;
		}
		
		if ( win == K) {
			if ( sum < min) {
				min = sum;
			}
			return;
		}
		
		int STR = list.get(idx).str;
		int DEX = list.get(idx).dex;
		int WISE = list.get(idx).wise;
		
		int diffSTR = STR-str;
		int diffDEX = DEX-dex;
		int diffWISE = WISE-wise;
		int nextSTR;
		int nextDEX;
		int nextWISE;
		int sumSTR;
		int sumDEX;
		int sumWISE;
		
		if ( diffSTR > 0) {
			nextSTR = diffSTR;
			sumSTR = diffSTR;
		}else {
			nextSTR = str;
			sumSTR = 0;
		}
		
		if ( diffDEX > 0) {
			nextDEX = diffDEX;
			sumDEX = diffDEX;
		}else {
			nextDEX = dex;
			sumDEX = 0;
		}
		
		if ( diffWISE > 0) {
			nextWISE = diffWISE;
			sumWISE = diffWISE;
		}else {
			nextWISE = wise;
			sumWISE = 0;
		}
		
		func(idx+1,win+1,sum+sumSTR+sumDEX+sumWISE,nextSTR,nextDEX,nextWISE);
		func(idx+1,win,sum,str,dex,wise);
		
	}
	
	public static class node{
		int str,dex,wise;
		node (int str,int dex,int wise){
			this.str = str;
			this.dex = dex;
			this.wise = wise;
		}
	}
}
