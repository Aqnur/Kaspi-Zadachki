package pervie_zadachki;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HomeWork {
	
	public static void main(String[] args) throws FileNotFoundException {

		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		
		int maxIndex = 0, minIndex = 0, sum = 0, prod = 1;
		int n;
		Scanner sc = new Scanner(input);
		n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			if (a[i] >= a[maxIndex]) {
				maxIndex = i;
			}
			if(a[i] <= a[minIndex]) {
				minIndex = i;
			}
			if(a[i] > 0) {
				sum += a[i];
			}
		}
		
		if(maxIndex < minIndex) {
			int tmp = minIndex;
			minIndex = maxIndex;
			maxIndex = tmp;
		}
		
		for(int i = minIndex + 1; i < maxIndex; i++) {
			prod *= a[i];
		}
		
		output.println(sum + " " + prod);
				
		sc.close();
		output.close();
	}

}
