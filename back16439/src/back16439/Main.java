package back16439;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int human[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		human = new int[N][M];
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < M ; j++) {
				human[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int boonmo = 6;
		int boonza = 1;
		for ( int i = M ; i > M-3 ; i--) {
			boonza *= i;
		}
	
		int cnt = boonza/boonmo;
		ArrayList<Integer> zohap[] = new ArrayList[cnt];
		for ( int i = 0 ; i < cnt ; i++) {
			zohap[i] = new ArrayList();
		}
		
		int tmpCnt = 0;
		for (int i = 0 ; i < M ; i++) {
			for ( int j = i+1 ; j < M ; j++) {
				for ( int k = j+1 ; k < M ; k++) {
					zohap[tmpCnt].add(i);
					zohap[tmpCnt].add(j);
					zohap[tmpCnt].add(k);
					tmpCnt++;
				}
			}
		}
		
		int max = 0;
		for ( int i = 0 ; i < cnt ; i++) {
			int tmpSum = 0;
			for ( int j = 0 ; j < N ; j++) {
				
				int tmpMax = Math.max(human[j][zohap[i].get(0)], Math.max(human[j][zohap[i].get(1)], human[j][zohap[i].get(2)]));
				tmpSum += tmpMax;
			}
			max = Math.max(max, tmpSum);
			
		}
		
		System.out.print(max);
	}
	
	
}
