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
			int D = Integer.parseInt(st.nextToken()); // ���
			int K = Integer.parseInt(st.nextToken()); // �Լ�
			
			if ( notPrime[D] ) {  // ��� ���� �˻�
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
			
			if ( notPrime[K] ) {  // �Լ� �˻�
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
			
			
			System.out.println("���: "+daewoong);
			System.out.println("�Լ�: "+kyuseong);
			
		}
		
		//daewoong.add(15);
		//System.out.println(daewoong.pollLast());
		//System.out.println(Dscore+" "+Kscore);
		
		if ( Dscore > Kscore) {
			System.out.println("�Ҽ��� �� �����");
		}else if ( Kscore > Dscore) {
			System.out.println("�Ҽ� ������ ���Լ�");
		}else if ( Kscore == Dscore){
			System.out.println("�쿭�� ���� �� ����");
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
