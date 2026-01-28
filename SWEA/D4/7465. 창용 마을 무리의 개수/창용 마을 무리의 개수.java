import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            parent = IntStream.rangeClosed(0, n).toArray();
            int m = Integer.parseInt(token.nextToken());
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                union(a, b);
            }
            Set<Integer> parentSet = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                find(i);
                parentSet.add(parent[i]);
            }
            sb.append('#').append(testCase).append(' ').append(parentSet.size()).append('\n');
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        int min = Integer.min(parentX, parentY);
        int max = Integer.max(parentX, parentY);
        parent[max] = min;
    }
}