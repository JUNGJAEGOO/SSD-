package back2518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int mama[];
	static int papa[];
	static int meme[];
	static int dp[][][][];
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for ( int i = 0 ; i < 3 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			if ( i == 0 ) {
				papa = new int[x];
				for ( int j = 0 ; j < x ; j++) {
					papa[j] = Integer.parseInt(st.nextToken());
				}
			}else if ( i == 1 ) {
				mama = new int[x];
				for ( int j = 0 ; j < x ; j++) {
					mama[j] = Integer.parseInt(st.nextToken());
				}
			}else {
				meme = new int[x];
				for ( int j = 0 ; j < x ; j++) {
					meme[j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		dp = new int[101][101][101][3];
		
		for ( int i = 0 ; i < 101 ; i++) {
			for ( int j = 0 ; j < 101 ; j++) {
				for ( int k = 0 ; k < 101 ; k++) {
					for ( int s = 0 ; s < 3 ; s++) {
						dp[i][j][k][s] = -1;
					}
				}
			}
		}
		
		System.out.print(Math.min(func(0,0,0,0),Math.min(func(0,0,0,1),func(0,0,0,2))));
		// 아빠 1
		// 엄마 (N/3) + 1;
		// 나  (N/3)*2 + 1;
		
	}
	
	public static int func(int pa,int ma,int me,int before) {
		
		if ( pa == papa.length && ma == mama.length && me == meme.length) {
			return 0;
		}

		
		int ret = dp[pa][ma][me][before];
		if ( ret != -1) {
			return ret;
		}
		ret = INF;
		
		
		ret = Math.min(ret, func(pa+1,ma,me,0) + papa[pa+1] - papa[pa]);
		
		
		
		return dp[pa][ma][me][before] = ret;
	}
}
