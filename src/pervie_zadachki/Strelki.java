package pervie_zadachki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Strelki {

	public static void main(String[] args) throws FileNotFoundException {
		
		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		Scanner sc = new Scanner(input);
		
		String str = sc.nextLine();
		String t;
		int cnt = 0;
		
		for (int i = 0; i < str.length() - 4; i++) {
			t = str.substring(i, i+5);
			if(t.equals(">>-->") || t.equals("<--<<")) {
				cnt++;
			}
		}
		
		output.println(cnt);
	}

}
