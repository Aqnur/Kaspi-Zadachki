package pervie_zadachki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DvoyakieChisla {

	public static void main(String[] args) throws FileNotFoundException {
		
		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		
		int n;
		Scanner sc = new Scanner(input);
		n = sc.nextInt();
		
		if(isDvoyaki(n)) {
			output.println(n);
		} else {
			int inc = n, dec = n;
			
			while(true) {
				inc++;
				dec--;
				if(isDvoyaki(inc)) {
					output.println(inc);
					break;
				}
				if(isDvoyaki(dec)) {
					output.println(dec);
					break;
				}
			}
		}
		
		sc.close();
		output.close();
		
	}
	
	static boolean isDvoyaki(int n) {
		
		Integer a = null, b = null;
		
		while(n > 0) {
			int cur = n % 10;
			n /= 10;
			
			if(a == null) {
				a = cur;
				continue;
			} else if(a == cur) {
				continue;
			}
			if(b == null) {
				b = cur;
			} else if(b != cur) {
				return false;
			}
		}
		return true;
	}

}
