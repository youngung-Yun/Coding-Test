import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();

		int[] list = new int[p];
		Arrays.fill(list, -1);
		
		int sequence = 0;
		int result = n;
		while (true) {
			result = (result * n) % p;
			if (list[result] != -1) {
				System.out.println(sequence - list[result] + 1);
				break;
			}
			list[result] = ++sequence;
		}
	}
}