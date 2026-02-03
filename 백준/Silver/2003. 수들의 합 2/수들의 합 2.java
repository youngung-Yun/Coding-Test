import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int sum = 0;
		int cnt = 0;

		while (true) {
			if (sum >= m) {
				if (sum == m) {
					cnt++;
				}
				sum -= nums[s++];
			} else if (e == n) {
				break;
			} else {
				sum += nums[e++];
			}
		}
		
		System.out.println(cnt);

	}

}
