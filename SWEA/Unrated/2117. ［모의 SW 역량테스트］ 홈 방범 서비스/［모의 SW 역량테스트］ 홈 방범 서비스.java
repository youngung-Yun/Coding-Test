import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testcase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			int maxHouse = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < (2 * n - 1); k++) {
						int currentHouse = 0;
						for (int r = 0; r < n; r++) {
							for (int c = 0; c < n; c++) {
								if (Math.abs(i - r) + Math.abs(j - c) <= k) {
									if (map[r][c] == 1)
										currentHouse++;
								}
							}
						}
						if (currentHouse * m >= Math.pow(k + 1, 2) + Math.pow(k, 2)) {
							maxHouse = currentHouse > maxHouse ? currentHouse : maxHouse;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + maxHouse);

		}
	}
}
