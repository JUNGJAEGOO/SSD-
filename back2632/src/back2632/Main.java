package back2632;
import java.io.*;
import java.util.*;
public class Main {
	static int pizza_1[],pizza_2[];
	
	static int n,m;
	public static void main(String args[])throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		pizza_1 = new int[m+m];
		pizza_2 = new int[n+n];
		
		int nsum = 0;
		int msum = 0;
		
		for ( int i = 0 ; i < m ; i++) {
			pizza_1[i] = Integer.parseInt(br.readLine());
			msum += pizza_1[i];
		}
		for ( int i = 0 ; i < n ; i++) {
			pizza_2[i] = Integer.parseInt(br.readLine());
			nsum += pizza_2[i];
		}
		
		for ( int i = m ; i < m+m ; i++) {
			pizza_1[i] = pizza_1[i-m];
		}
		for ( int i = n ; i < n+n ; i++) {
			pizza_2[i] = pizza_2[i-n];
		}
		
		HashMap<Integer,Integer> mmap = new HashMap<>();
		for ( int i = 0 ; i < m ; i++) {
			int sum = 0;
			
			for ( int j = i ; j < m+i-1 ; j++) {
				sum += pizza_1[j];
				if ( sum > N) {
					break;
				}
				if ( mmap.get(sum) == null ) {
					mmap.put(sum, 1);
				}else {
					mmap.replace(sum,mmap.get(sum)+1);
				}
			}
		}
		
		HashMap<Integer,Integer> nmap = new HashMap<>();
		for ( int i = 0 ; i < n ; i++) {
			int sum = 0;
			
			for ( int j = i ; j <n+i-1 ; j++) {
				sum += pizza_2[j];
				if ( sum > N) {
					break;
				}
				if ( nmap.get(sum) == null ) {
					nmap.put(sum, 1);
				}else {
					nmap.replace(sum, nmap.get(sum)+1);
				}
			}
		}
		nmap.put(0, 1);
		mmap.put(0, 1);
		nmap.put(nsum, 1);
		mmap.put(msum, 1);
		
		int ans = 0;
		
		Iterator<Integer> itr = mmap.keySet().iterator();
		while ( itr.hasNext() ) {
			int key = itr.next();
			//System.out.println(key+" "+mmap.get(key));
			if ( nmap.get(N-key) != null ) {
				//System.out.println("haha "+(N-key)+" "+nmap.get(N-key));
				ans += nmap.get(N-key) * mmap.get(key);
			}
		}
		
		System.out.print(ans);
	}

}
