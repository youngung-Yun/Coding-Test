import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] paper = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            for (int j = ay; j < by; j++) {
                for (int l = ax; l < bx; l++) {
                    paper[j][l] = 1;
                }
            }
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int areaCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i][j] == 1) {
                    continue;
                }
                ++areaCount;
                Deque<int[]> queue = new ArrayDeque<>();
                queue.offerLast(new int[] {i, j});
                int area = 1;
                paper[i][j] = 1;
                while (!queue.isEmpty()) {
                    int[] curr = queue.removeFirst();
                    for (int[] direction : directions) {
                        int dx = curr[0] + direction[0];
                        int dy = curr[1] + direction[1];
                        if (dx < 0 || dy < 0 || dx >= m || dy >= n) {
                            continue;
                        }
                        if (paper[dx][dy] == 1) {
                            continue;
                        }
                        paper[dx][dy] = 1;
                        queue.offerLast(new int[] {dx, dy});
                        ++area;
                    }
                }
                pq.add(area);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(areaCount).append('\n');
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(' ');
        }
        System.out.println(sb.toString());
    }
}
