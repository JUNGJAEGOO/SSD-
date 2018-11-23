package back16434;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int Hatk = Integer.parseInt(st.nextToken());
		
		int t[] = new int[N];
		int a[] = new int[N];
		int h[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			t[i] = Integer.parseInt(st.nextToken());
			a[i] = Integer.parseInt(st.nextToken());
			h[i] = Integer.parseInt(st.nextToken());
			
		}
		
		long left = 1;
		long right = Long.MAX_VALUE;
		//System.out.println(right);
		
		long ans = -1;
		while ( left <= right) {
			
			long mid = (left+right) / 2;
			
			//System.out.println(left+" "+right+" "+mid);
			
			boolean OK = true;
			long nowHP = mid;
			long atk = Hatk;
			for ( int i = 0 ; i < N ; i++) {
				if ( t[i] == 1) {
					long nam = h[i]%atk;
					long mok = h[i]/atk;
					if ( nam == 0) {
						if ( mok-1 != 0 ) {
							nowHP -= a[i] * (mok - 1) ;
						}
						
					}else {
						nowHP -= a[i] * ( mok );
					}
				}else {
					atk += a[i];
					if ( nowHP + h[i] > mid) {
						nowHP = mid;
					}else {
						nowHP += h[i];
					}
				}
				
				//System.out.println(nowHP+" ");
				
				if ( nowHP <= 0 ) {
					OK = false;
					break;
				}
			}
			
			if( OK ) {
				ans = mid;
				right = mid - 1;
				
			}else {
				left = mid + 1;
			}
			
		}
		
		System.out.print(ans);
		
	}
}
