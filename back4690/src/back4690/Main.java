package back4690;

public class Main {
	public static void main(String args[]) {
		
		StringBuilder sb = new StringBuilder();
		
		for ( int a = 2 ; a <= 100 ; a++) {
			for ( int b = 2 ; b<= 100 ; b++) {
				for ( int c = 2 ; c<= 100 ; c++) {
					for ( int d = 2 ; d<= 100 ; d++) {
						
						if ( a*a*a == b*b*b + c*c*c + d*d*d) {
							if ( b <= c && c <= d) {
								sb.append("Cube = "+a+", Triple = ("+b+","+c+","+d+")\n");
							}
						}
						
					}	
				}
			}
		}
		
		System.out.print(sb);
	}
}
