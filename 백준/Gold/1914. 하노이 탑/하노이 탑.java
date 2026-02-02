import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger count = new BigInteger("0");
	static StringBuilder sb = new StringBuilder();

	public static void hanoi(int num, int start, int target, int namoji) {
		if (num == 1) {
			sb.append(start).append(" ").append(target).append("\n");
			return;
		}
		hanoi(num - 1, start, namoji, target);
		hanoi(1, start, target, namoji);
		hanoi(num - 1, namoji, target, start);
	}

	public static BigInteger hanoi_num(int n) {
		BigInteger base = new BigInteger("2");
		return base.pow(n).subtract(new BigInteger("1"));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		count = hanoi_num(n);
		if (n > 20) {
			System.out.println(count);
		} else {
			hanoi(n, 1, 3, 2);
			System.out.println(count);
			System.out.println(sb);
		}

	}

}
