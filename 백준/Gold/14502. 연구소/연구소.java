import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 빈 칸 중 벽을 세울 3곳 선정
        // 2. 벽 세우고 바이러스에 대해 BFS로 바이러스 퍼뜨림
        // 3. 안전 구역의 수 세기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                lab[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n * m - 2; i++) {
            int x1 = i / m;
            int y1 = i % m;
            if (lab[x1][y1] != 0) {
                continue;
            }
            for (int j = i + 1; j < n * m - 1; j++) {
                int x2 = j / m;
                int y2 = j % m;
                if (lab[x2][y2] != 0) {
                    continue;
                }
                for (int k = j + 1; k < n * m; k++) {
                    int x3 = k / m;
                    int y3 = k % m;
                    if (lab[x3][y3] != 0) {
                        continue;
                    }

                    int[][] clone = new int[n][m];
                    // lab 복사
                    for (int row = 0; row < n; ++row) {
                        clone[row] = Arrays.copyOf(lab[row], m);
                    }
                    // 벽 세움
                    clone[x1][y1] = 1;
                    clone[x2][y2] = 1;
                    clone[x3][y3] = 1;
                    // 바이러스 퍼짐
                    virusLeak(clone, n, m);
                    // 안전 구역 개수 세기
                    int safeArea = 0;
                    for (int[] row : clone) {
                        safeArea += Arrays.stream(row).filter((e) -> e == 0).count();
                    }
                    result = Integer.max(result, safeArea);
                }
            }
        }
        System.out.println(result);
    }

    private static void virusLeak(int[][] lab, int n, int m) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (lab[row][col] == 2) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[] {row ,col});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        for (int[] direction : directions) {
                            int dx = curr[0] + direction[0];
                            int dy = curr[1] + direction[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                                continue;
                            }
                            if (lab[dx][dy] == 0) {
                                lab[dx][dy] = 2;
                                queue.offerLast(new int[] {dx, dy});
                            }
                        }
                    }
                }
            }
        }
    }
}