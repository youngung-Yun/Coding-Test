import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] adjacency = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adjacency[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(i);
            while (!queue.isEmpty()) {
                int curr = queue.removeFirst();
                for (int j = 0; j < n; j++) {
                    if (adjacency[curr][j] == 1 && result[i][j] != 1) {
                        queue.offerLast(j);
                        result[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int e : row) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

}