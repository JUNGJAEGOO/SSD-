package back1181;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set[] = new HashSet[51];
		
		for ( int i = 1 ; i <= 50 ; i++) {
			set[i] = new HashSet<>();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			int len = tmp.length();
			set[len].add(tmp);
		}
		
		String arr[][] = new String[51][20001];
		
		for ( int i = 1 ; i <= 50 ; i++) {
			arr[i] = set[i].toArray(new String[set[i].size()]);
			Arrays.sort(arr[i]);
		}
		//String arr[] = set.toArray(new String[set.size()]);
		//Arrays.sort(arr);
		
		for ( int i = 1 ; i <= 50 ; i++) {
			if ( set[i].size() != 0) {
				for ( int j = 0 ; j<set[i].size() ; j++) {
					System.out.println(arr[i][j]);
				}
			}
		}
	}
}
