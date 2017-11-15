package back1924;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int x = in.nextInt();
	int y = in.nextInt();
	
	String day[][] = new String[12][31];
	String start[] = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
	int count = 0;
	for ( int i = 0 ; i < 12 ; i++) {
		if ( i == 1 ) {
			for ( int j = 0 ; j<28;j++) {
				day[i][j] = start[count];
				count = (count + 1) % 7;
			}
		}
		else if(i==0 ||i==2 ||i==4 ||i==6 ||i==7 ||i==9 ||i==11) {
			for ( int j = 0 ; j<31;j++) {
				day[i][j] = start[count];
				count = (count + 1) % 7;
			}
		}
		else {
			for ( int j = 0 ; j<30;j++) {
				day[i][j] = start[count];
				count = (count + 1) % 7;
			}
		}
		
	}
	
	/*for ( int i = 0 ; i < 12 ; i++) {
		for ( int j = 0 ; j < 31 ; j++) {
			System.out.print(day[i][j]+" ");
			if ( j!=0 && j%7==0) { System.out.println();}
		}
		System.out.println("--------------------------");
		
	}*/
	System.out.println(day[x-1][y-1]);
	
	}
	
}
