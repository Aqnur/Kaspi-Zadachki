package vtorie_zadachki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class RimskieCifri {

	public static void main(String[] args) throws FileNotFoundException {
		
		File input = new File("input.txt");
		PrintWriter output = new PrintWriter("output.txt");
		Scanner sc = new Scanner(input);
		
		String str = sc.nextLine();
        String nums[] = str.split("/");
        if (nums.length != 2) {
            output.println("ERROR");
            output.close();
            return;
        }
        int a = romainToInt(nums[0]);
        int b = romainToInt(nums[1]);
        if (a == -1 || b == -1 || a > 999 || b > 999) {
            output.println("ERROR");
            output.close();
            return;
        }
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b == 1) {
            output.println(intToRomain(a));
        } else {
            output.println(intToRomain(a) + "/" + intToRomain(b));
        }
		sc.close();
		output.close();
		
	}

	private static int gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}
	
	private static String intToRomain(int n) {
		 int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < values.length; i++) {
            while(n >= values[i]) {
                n -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
	}
	
	private static int romainToInt(String s) {
		if(s == null || s.length() == 0) {
			return -1;
		}
		
		HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        for(int i = 0; i < len; ++i) {
            if (!map.containsKey(s.charAt(i))) {
                return -1;
            }
        }

        int result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
	}
	
}
