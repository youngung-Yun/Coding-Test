import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testcase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc < testcase + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] snacks = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(snacks);

			int s = 0;
			int e = n - 1;
			int maxsum = -1;

			while (s < e) {
				int sum = snacks[s] + snacks[e];
				if (sum > m) {
					e--;
				} else {
					if (maxsum < sum) {
						maxsum = sum;
					}
					s++;
				}
			}
			
			System.out.println("#" + tc + " " + maxsum);
			
		}
	}

}
