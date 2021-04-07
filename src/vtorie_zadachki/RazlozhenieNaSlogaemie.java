package vtorie_zadachki;

import java.util.Scanner;

public class RazlozhenieNaSlogaemie {

	static int a[] = new int[111];

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			a[i] = 0;
		}
		
		dec(n, n, 0);
		
	}
	
	static void dec(int n, int k, int i) {
		if(n < 0) return;
		if(n == 0) {
			for(int j = 0; j < i; j++) {
				System.out.print(a[j] + "+");
			}
			System.out.println();
		} else {
			if(n - k >= 0) {
				a[i] = k;
				dec(n - k, k, i + 1);
			}
		}
		if(k - 1 > 0) {
			dec(n, k-1, i);
		}
	}
}
