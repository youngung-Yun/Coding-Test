import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 400 * 10_000;
    static int v;
    static int[][] adj;
    static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        adj = new int[v+1][v+1];
        initAdj();

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            adj[a][b] = c;
        }

        findShortestPath();
        
        boolean canReturn = false;
        int shortestCycle = INF * 2;
        for (int from = 1; from <= v; from++) {
            for (int to = 1; to <= v; to++) {
                if (from == to) {
                    continue;
                }
                if (adj[from][to] != INF && adj[to][from] != INF) {
                    canReturn = true;
                    shortestCycle = Integer.min(shortestCycle, adj[from][to] + adj[to][from]);
                }
            }
        }
        System.out.println(canReturn ? shortestCycle : -1);
    }

    static void initAdj() {
        for (int r = 1; r <= v; r++) {
            for (int c = 1; c <= v; c++) {
                if (r == c) {
                    adj[r][c] = 0;
                } else {
                    adj[r][c] = INF;
                }
            }
        }
    }

    static void findShortestPath() {
        for (int from = 1; from <= v; from++) {
            for (int to = 1; to <= v; to++) {
                for (int through = 1; through <= v; through++) {
                    adj[from][to] = Integer.min(adj[from][to], adj[from][through] + adj[through][to]);
                }
            }
        }
    }

    static void printAdj() {
        for (int[] row : adj) {
            System.out.println(Arrays.toString(row));
        }
    }
}