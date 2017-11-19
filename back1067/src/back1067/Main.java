package back1067;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		Deque<Integer> dq1 = new LinkedList<>();
		Deque<Integer> dq2 = new LinkedList<>();
		for ( int i = 0 ; i < N ; i++) {
			dq1.add(in.nextInt());
		}
		for ( int i = 0 ; i < N ; i++) {
			dq2.add(in.nextInt());
		}
		
		int max = 0;
		int sum = 0;
		Object[] tmp1 = new Object[N];
		Object[] tmp2 = new Object[N];
		
/*		for ( int i = 0 ; i < N ; i++) {
			System.out.println(Integer.parseInt(tmp1[i].toString()) );
		}*/
		
		for ( int i = 0 ; i < N ; i++) {
			sum = 0;
			tmp1 = 	dq1.toArray();
			tmp2 =  dq2.toArray();
			for ( int s = 0 ; s < N ; s++) {
				//System.out.println(Integer.parseInt(tmp1[s].toString())+"*"+Integer.parseInt(tmp2[s].toString()));
				sum+= Integer.parseInt(tmp1[s].toString())*Integer.parseInt(tmp2[s].toString());
			}
			//System.out.println(sum);
			if ( max < sum) {
				max = sum;
			}
			
			int tmp = dq1.pollFirst();
			dq1.addLast(tmp);
		
		}
		System.out.println(max);
		
	}
}
