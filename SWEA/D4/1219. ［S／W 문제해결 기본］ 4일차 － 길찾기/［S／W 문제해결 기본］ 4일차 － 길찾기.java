import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    private static int[] edge1;
    private static int[] edge2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());

            edge1 = new int[100];
            Arrays.fill(edge1, -1);
            edge2 = new int[100];
            Arrays.fill(edge2, -1);

            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                if (edge1[from] == -1) {
                    edge1[from] = to;
                } else {
                    edge2[from] = to;
                }
            }
            boolean isReachable = dfs(edge1, 0) || dfs(edge2, 0);

            sb.append('#').append(t).append(' ').append(isReachable ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean dfs(int[] edge, int current) {
        if (edge[current] == -1) {
            return false;
        } else if (edge[current] == 99) {
            return true;
        } else{
            return dfs(edge1, edge[current]) || dfs(edge2, edge[current]);
        }
    }
}