import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int start = Integer.parseInt(token.nextToken());
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                adj.add(new ArrayList<>());
            }
            token = new StringTokenizer(br.readLine());
            // init adjacency list
            for (int i = 0; i < n / 2; i++) {
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                adj.get(a).add(b);
            }

            Deque<Integer> queue = new ArrayDeque<>();
            int[] depth = new int[101];
            Arrays.fill(depth, -1);
            depth[start] = 0;
            queue.offerLast(start);

            while (!queue.isEmpty()) {
                int curr = queue.removeFirst();
                for (int node : adj.get(curr)) {
                    if (depth[node] != -1) {
                        continue;
                    }
                    depth[node] = depth[curr] + 1;
                    queue.offerLast(node);
                }
            }

            int maxDepth = 0;
            int maxNumber = 0;
            for (int i = 1; i <= 100; i++) {
                if (maxDepth <= depth[i]) {
                    maxDepth = depth[i];
                    maxNumber = i;
                }
            }

            sb.append('#').append(testCase).append(' ').append(maxNumber).append('\n');
        }
        System.out.println(sb);
    }
}