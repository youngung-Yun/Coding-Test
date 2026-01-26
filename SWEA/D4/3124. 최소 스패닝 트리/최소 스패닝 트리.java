import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());

            parent = IntStream.rangeClosed(0, v).toArray();

            int[][] edges = new int[e][3];
            for (int i = 0; i < e; i++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());
                // [start, end, cost]
                edges[i] = new int[] {a, b, c};
            }
            Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

            long answer = 0L;
            int count = 0;
            for (int[] edge : edges) {
                // 같은 집합이 아닌 경우
                if (union(edge[0], edge[1])) {
                    answer += edge[2];
                    count += 1;
                }
                // 간선 v - 1개 모두 선택했으면 종료
                if (count == v - 1) {
                    break;
                }
            }

            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        // 같은 집합
        if (parentX == parentY) {
            return false;
        }

        if (parentX < parentY) {
            parent[parentY] = parentX;
        } else {
            parent[parentX] = parentY;
        }
        return true;
    }
}