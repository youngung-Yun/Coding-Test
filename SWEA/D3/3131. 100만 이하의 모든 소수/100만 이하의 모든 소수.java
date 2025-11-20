import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		boolean[] isPrime = new boolean[1_000_000 + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= 1_000; i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i + i; j <= 1_000_000; j += i) {
				isPrime[j] = false;
			}
		}

		for (int i = 1; i <= 1_000_000; i++) {
			if (isPrime[i]) {
				System.out.printf("%d ", i);
			}
		}
	}
}