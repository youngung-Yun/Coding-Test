import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    final static int INF = Integer.MAX_VALUE;
    static int n;
    static int[][] coords;
    static int[][] distance;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        /*
         * 1. 플로이드 워셜로 모든 좌표에 대한 최단거리 구함
         * 2. 조합으로 모든 방문 순서 구함
         * 3. 그 중 가장 경로가 짧은 거리 채택
         */
        for (int testcase = 1; testcase <= t; testcase++) {
            n = Integer.parseInt(bf.readLine());
            coords = new int[n+2][2];
            ans = INF;

            StringTokenizer stk = new StringTokenizer(bf.readLine());

            // [0] = 회사, [1] = 집
            coords[0] = new int[] { Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) };
            coords[1] = new int[] { Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) };
            for (int i = 2; i <= n + 1; i++) {
                coords[i] = new int[] { Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) };
            }

            distance = new int[n+2][n+2];
            for (int a = 0; a < n + 2; a++) {
                for (int b = 0; b < n + 2; b++) {
                    distance[a][b] = Math.abs(coords[a][0] - coords[b][0]) + Math.abs(coords[a][1] - coords[b][1]);
                }
            }

            for (int passed = 0; passed < n + 2; passed++) {
                for (int from = 0; from < n + 2; from++) {
                    for (int to = 0; to < n + 2; to++) {
                        distance[from][to] = Integer.min(distance[from][to], distance[from][passed] + distance[passed][to]);
                    }
                }
            }

            int[] seq = new int[n+2];
            seq[0] = 0;
            seq[n+1] = 1;
            boolean[] visited = new boolean[n+2];
            visited[0] = visited[1] = true;
            dfs(seq, visited, 0);

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dfs(int[] seq, boolean[] visited, int depth) {
        if (depth == n) {
            int totalDistance = 0;
            for (int now = 0; now < n + 1; now++) {
                totalDistance += distance[seq[now]][seq[now+1]];
            }
            ans = Integer.min(ans, totalDistance);
        }

        for (int client = 0; client < n + 2; client++) {
            if (visited[client]) {
                continue;
            }
            visited[client] = true;
            seq[depth + 1] = client;
            dfs(seq, visited, depth + 1);
            visited[client] = false;
        }
    }
}
