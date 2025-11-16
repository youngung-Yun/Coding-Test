import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String a = sc.next();
			String b =  sc.next();

			int[] counting = new int[26];
			for (char ch : a.toCharArray()) {
				++counting[ch - 'a'];
			}
			for (char ch : b.toCharArray()) {
				--counting[ch - 'a'];
			}

			boolean isAnagram = true;
			for (int count : counting) {
				if (count != 0) {
					isAnagram = false;
				}
			}

			System.out.printf("%s & %s are %s\n", a, b, (isAnagram ? "anagrams." : "NOT anagrams."));
		}
	}
}