import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] offset = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] game = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                game[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty() && !visited[n-1][n-1]) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int jump = game[r][c];
            for (int[] o : offset) {
                int nr = r + (o[0] * jump);
                int nc = c + (o[1] * jump);
                if (nr >= n || nc >= n || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }

        System.out.println(visited[n-1][n-1] ? "HaruHaru" : "Hing");
    }
}