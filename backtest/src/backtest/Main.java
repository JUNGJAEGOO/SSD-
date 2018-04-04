package backtest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine().trim());
           
            
            for (int i = 0; i < T; i ++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
                int N = Integer.parseInt(tokenizer.nextToken());
                int K = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());
								
				System.out.println(func(N,K,M));
            }
        }
    }
	
	public static long func(int n,int k,int m){
		
		long go1 =1 , go2 = 1;
		
		long one = 1;
		long ret = 1;
		for ( int i = 1 ; i<= m ; i++) {
			one = one * (n-i+1) % 1003001;
			ret = ret * i % 1003001;
		}
		//System.out.println(one*zegob(ret,1003001-2)%1003001);
		
		long two = 1;
		long ret2 = 1;
		for ( int i = 1 ; i<= m ; i++) {
			two = two * (n-i+1) % 1003001;
			ret2 = ret2 * i % 1003001;
		}
		//System.out.println(two*zegob(ret2,1003001-2)%1003001);
		
		go1 = one*zegob(ret,1003001-2)%1003001;
		go2 = two*zegob(ret2,1003001-2)%1003001;
		
		return (go1 * go2) % 1003001;
			
	}
	
	public static long zegob(long x,long y) {
		
		if ( y == 0) {
			return 1;
		}
		if ( (y&1) == 1) {
			return zegob(x,y-1)*x % 1003001;
		}
		long half = zegob(x,y>>1);
		return half*half % 1003001;
	}
}
