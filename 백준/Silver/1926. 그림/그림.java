import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(row[j]);
                paper[i][j] = x;
            }
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int pictureCount = 0;
        int largestPicture = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    paper[i][j] = 0;
                    int size = 0;
                    ++pictureCount;
                    queue.addLast(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        ++size;
                        for (int[] direction : directions) {
                            int dx = curr[0] + direction[0];
                            int dy = curr[1] + direction[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                                continue;
                            }
                            if (paper[dx][dy] == 0) {
                                continue;
                            }
                            paper[dx][dy] = 0;
                            queue.addLast(new int[] {dx, dy});
                        }
                    }
                    largestPicture = Integer.max(largestPicture, size);
                }
            }
        }
        System.out.println(pictureCount);
        System.out.println(largestPicture);
    }
}
