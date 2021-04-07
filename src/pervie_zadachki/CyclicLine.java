package pervie_zadachki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CyclicLine {

	public static void main(String[] args) throws FileNotFoundException {

		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		
		Scanner sc = new Scanner(input);
		String str = sc.nextLine();
		
		int[] func = prefix(str);
		output.println(func.length - func[func.length - 1]);
		sc.close();
		output.close();
	}
	
	static int[] prefix(String s) {
		int[] a = new int[s.length()];
		
		int k = 0;
		for(int i = 2; i < s.length(); i++) {
			while(k > 0 && s.charAt(k) != s.charAt(i)) {
				k = a[k];
			}
			if(s.charAt(k) == s.charAt(i)) {
				k = k + 1;
			}
			a[i] = k;
		}
		return a;
	}

}
