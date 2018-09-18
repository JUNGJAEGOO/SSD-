package back14622;

import java.io.*;
import java.util.*;

public class Main {
	static boolean notPrime[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		notPrime = new boolean[5_000_001];
		eratos();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeSet<Integer> daewoong = new TreeSet<>();
		TreeSet<Integer> kyuseong = new TreeSet<>();
		
		int sosoo[] = new int[5_000_001];
		long Dscore = 0;
		long Kscore = 0;

		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int D = Integer.parseInt(st.nextToken()); // 대웅
			int K = Integer.parseInt(st.nextToken()); // 규성
			
			if ( notPrime[D] ) {  // 대웅 부터 검사
				if ( kyuseong.size() < 3 ) {
					Kscore += 1000;
				}else {
					
					int tmp1 = kyuseong.pollLast();
					int tmp2 = kyuseong.pollLast();
					int tmp3 = kyuseong.pollLast();
					Kscore += tmp3;
					kyuseong.add(tmp1);
					kyuseong.add(tmp2);
					kyuseong.add(tmp3);
					
				}
			}else {
				if ( sosoo[D] >= 1) {
					Dscore -= 1000;
				}else {
					sosoo[D] = 1;
					daewoong.add(D);

				}
			}
			
			if ( notPrime[K] ) {  // 규성 검사
				if ( daewoong.size() < 3 ) {
					Dscore += 1000;
				}else {
					int tmp1 = daewoong.pollLast();
					int tmp2 = daewoong.pollLast();
					int tmp3 = daewoong.pollLast();
					Dscore += tmp3;
					daewoong.add(tmp1);
					daewoong.add(tmp2);
					daewoong.add(tmp3);
					
				}
			}else {
				if ( sosoo[K] >= 1) {
					Kscore -= 1000;
				}else {
					sosoo[K] = 1;
					kyuseong.add(K);
				}
			}
			
			
			System.out.println("대웅: "+daewoong);
			System.out.println("규성: "+kyuseong);
			
		}
		
		//daewoong.add(15);
		//System.out.println(daewoong.pollLast());
		//System.out.println(Dscore+" "+Kscore);
		
		if ( Dscore > Kscore) {
			System.out.println("소수의 신 갓대웅");
		}else if ( Kscore > Dscore) {
			System.out.println("소수 마스터 갓규성");
		}else if ( Kscore == Dscore){
			System.out.println("우열을 가릴 수 없음");
		}
	}
	
	public static void eratos() {
		notPrime[0] = true;
		notPrime[1] = true;
		
		for ( int i = 2 ; i < 5_000_001 ; i++) {
			if ( notPrime[i] == false) {
				for ( int j = i+i ; j < 5_000_001 ; j = j+i) {
					if ( j > 5_000_000) {
						break;
					}
					notPrime[j] = true;
				}
			}
		}
	}
}
