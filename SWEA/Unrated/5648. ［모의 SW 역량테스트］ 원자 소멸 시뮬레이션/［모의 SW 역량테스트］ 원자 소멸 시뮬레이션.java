import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static int M = 4001; // 좌표의 크기를 2배로 만들어야 붙어있는 원자들도 충돌했을 때 겹치는 좌표가 나옴
	// 상(y 좌표가 증가하는 방향) - 하 - 좌 - 우
	static int[][] map = new int[M][M], deltas = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testcase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testcase; tc++) {
			int n = Integer.parseInt(br.readLine());

			ArrayDeque<int[]> atoms = new ArrayDeque<>();
			int total = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				map[y][x] = k;
				atoms.offer(new int[] { x, y, d, k });
			}

			while (!atoms.isEmpty()) {
				int[] currentAtom = atoms.poll();

				if (map[currentAtom[1]][currentAtom[0]] != currentAtom[3]) {
					total += map[currentAtom[1]][currentAtom[0]];
					map[currentAtom[1]][currentAtom[0]] = 0;
					continue;
				}

				map[currentAtom[1]][currentAtom[0]] = 0;
				int ny = currentAtom[1] + deltas[currentAtom[2]][0];
				int nx = currentAtom[0] + deltas[currentAtom[2]][1];
				if (ny >= 0 && ny < M && nx >= 0 && nx < M) {
					map[ny][nx] += currentAtom[3];
					currentAtom[0] = nx;
					currentAtom[1] = ny;
					atoms.offer(currentAtom);
				}
			}

			System.out.println("#" + tc + " " + total);

		}
	}
}