package back6987;

import java.util.*;

public class Main {
	
	static int sum = 0;
	static node arr[];
	static boolean visit[];
	static boolean backres;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		arr = new node[6];
		int T = 4;
		while ( T > 0) {
			boolean pass = true;
			int winsum = 0;
			int losesum = 0;
			visit = new boolean[6];
			for (int i = 0 ; i < 6 ; i++) {
				arr[i] = new node();
				arr[i].win = in.nextInt();
				arr[i].draw = in.nextInt();
				arr[i].lose = in.nextInt();
				if ( arr[i].win + arr[i].draw + arr[i].lose != 5) {
					pass = false;
				}
				if ( arr[i].win > 5 || arr[i].draw > 5 || arr[i].lose > 5) {
					pass = false;
				}
				winsum += arr[i].win;
				losesum += arr[i].lose;
			}
			
			
			backres = false;
			back(0,1);
			//System.out.println(backdraw);
			
			if ( pass && backres) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
			
			T--;
		}
		
	}
	
	public static void back(int p,int q) {
		
		if ( p == 6) {
			backres = true;
		}else if ( q == 6) {
			back(p+1,p+2);
		}else {
			arr[p].win--;
			arr[q].lose--;
			if ( arr[p].win >= 0 && arr[q].lose >= 0) {
				back(p,q+1);
			}
			arr[p].win++;
			arr[q].lose++;
			arr[p].draw--;
			arr[q].draw--;
			if ( arr[p].draw >= 0 && arr[q].draw >= 0) {
				back(p,q+1);
			}
			arr[p].draw++;
			arr[q].draw++;
			arr[p].lose--;
			arr[q].win--;
			if ( arr[p].lose >= 0 && arr[q].win >= 0) {
				back(p,q+1);
			}
			arr[p].lose++;
			arr[q].win++;
		}
		
	}
	
	
	public static class node{
		int win;
		int draw;
		int lose;
	}

}
