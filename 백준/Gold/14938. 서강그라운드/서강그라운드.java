import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX = 100 * 15;

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] adjacency = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    adjacency[i][j] = MAX;
                }
            }
        }
        int[] itemCounts = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCounts[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjacency[a][b] = dist;
            adjacency[b][a] = dist;
        }

        for (int through = 1; through <= n; ++through) {
            for (int from = 1; from <= n; ++from) {
                for (int dest = 1; dest <= n; ++dest) {
                    adjacency[from][dest] = Integer.min(adjacency[from][dest], adjacency[from][through] + adjacency[through][dest]);
                }
            }
        }
        int result = 0;
        for (int landingPoint = 1; landingPoint <= n; ++landingPoint) {
            int sum = 0;
            for (int dest = 1; dest <= n; ++dest) {
                if (adjacency[landingPoint][dest] <= m) {
                    sum += itemCounts[dest];
                }
            }
            result = Integer.max(result, sum);
        }
        System.out.println(result);
    }
}
