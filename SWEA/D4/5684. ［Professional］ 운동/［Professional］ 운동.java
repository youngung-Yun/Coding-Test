import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static int INF = 10_000 * 400;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int[][] distance = initDistance(n);
            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(stk.nextToken());
                int end = Integer.parseInt(stk.nextToken());
                int cost = Integer.parseInt(stk.nextToken());
                distance[start][end] = cost;
            }


            for (int through = 1; through <= n; through++) {
                for (int from = 1; from <= n; from++) {
                    for (int to = 1; to <= n; to++) {
                        distance[from][to] = Integer.min(distance[from][to], distance[from][through] + distance[through][to]);
                    }
                }
            }

            boolean hasCycle = false;
            int shortestCycle = INF * 2;
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    if (distance[from][to] == INF || distance[to][from] == INF) {
                        continue;
                    }
                    hasCycle = true;
                    if (from == to) {
                        shortestCycle = Integer.min(shortestCycle, distance[from][to]);
                    } else {
                        shortestCycle = Integer.min(shortestCycle, distance[from][to] + distance[to][from]);
                    }
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(hasCycle ? shortestCycle : -1).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int[][] initDistance(int n) {
        int[][] distance = new int[n+1][n+1];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                distance[r][c] = INF;
            }
        }
        return distance;
    }
}