package pervie_zadachki;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Nuli {

	public static void main(String[] args) throws FileNotFoundException {
		
		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		
		Scanner sc = new Scanner(input);
		String str = sc.nextLine();
		
		int cnt = 0;
		int k = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '0') {
				cnt++;
			} else {
				if(k < cnt) {
					k = cnt;
					cnt = 0;
				} else {
					cnt = 0;
				}
			}
		}
		
		output.println(k);
		
		sc.close();
		output.close();
	}

}
