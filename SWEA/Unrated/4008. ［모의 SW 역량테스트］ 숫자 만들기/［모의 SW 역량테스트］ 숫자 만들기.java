import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, max, min;
	static int[] opers, nums, result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testcase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			opers = new int[4];
			nums = new int[N];
			result = new int[N - 1];
			visited = new boolean[N - 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opers[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			getMaxMin(0, 0, 0);

			System.out.println("#" + tc + " " + (max - min));

		}

	}

	public static void getMaxMin(int depth, int start, int index) {
		if (depth == opers[index]) {
			if (index == 3) {
				int sum = nums[0];
				for (int i = 1; i < N; i++) {
					switch (result[i - 1]) {
					case 0:
						sum += nums[i];
						continue;
					case 1:
						sum -= nums[i];
						continue;
					case 2:
						sum *= nums[i];
						continue;
					case 3:
						sum /= nums[i];
						continue;
					default:
						continue;
					}
				}
				max = sum > max ? sum : max;
				min = sum < min ? sum : min;
				return;
			} else {
				getMaxMin(0, 0, index + 1);
				return;
			}
		}

		for (int i = start; i < N - 1; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			result[i] = index;
			getMaxMin(depth + 1, i + 1, index);
			visited[i] = false;
		}
	}
}
