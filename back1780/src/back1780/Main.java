package back1780;

import java.util.*;

public class Main {
	static int N;
	static int mat[][];
	static int minus;
	static int zero;
	static int plus;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N+1][N+1];
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		func(1,1,N,N);
		
		System.out.println(minus+"\n"+zero+"\n"+plus);
		
	}
	
	public static void func(int sx,int sy,int ex,int ey) {
		
		System.out.println(sx+" "+sy+" "+ex+" "+ey);
		
		boolean pass = true;
		int idx = -2;
		
		lop:
		for ( int i = sx ; i <= ex ; i++) {
			for ( int j = sy ; j <= ey ; j++) {
				if( idx == -2) {
					idx = mat[i][j];
				}else {
					if ( idx != mat[i][j]) {
						pass = false;
						break lop;
					}
				}
				
			}
		}
		
		if ( pass ) {
			
			if ( idx == 0) {
				zero += 1;
			}else if ( idx == 1) {
				plus += 1;
			}else if ( idx == -1) {
				minus += 1;
			}
			System.out.println(idx+" Áõ°¡");
			return;
		}else {
			
			int len = (ey-sy + 1)/3;
			
			func(sx,sy,sx+len-1,sy+len-1);
			func(sx,sy+len,sx+len-1,sy+2*len-1);
			func(sx,sy+2*len,sx+len-1,sy+3*len-1);
			
			
			func(sx+len,sy,sx+len*2-1,sy+len-1);
			func(sx+len,sy+len,sx+len*2-1,sy+2*len-1);
			func(sx+len,sy+2*len,sx+len*2-1,sy+3*len-1);
			
			func(sx+2*len,sy,sx+len*3-1,sy+len-1);
			func(sx+2*len,sy+len,sx+len*3-1,sy+2*len-1);
			func(sx+2*len,sy+2*len,sx+len*3-1,sy+3*len-1);
			
			
		}
		
	}
}
