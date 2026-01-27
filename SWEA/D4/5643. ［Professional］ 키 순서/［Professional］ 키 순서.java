import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                adj.get(a).add(b);
            }

            // [a][b]는 a에서 b로 갈 수 있는지
            boolean[][] canVisit = new boolean[n+1][n+1];
            for (int start = 1; start <= n; start++) {
                Deque<Integer> queue = new ArrayDeque<>();
                queue.offerLast(start);
                canVisit[start][start] = true;
                while (!queue.isEmpty()) {
                    int node = queue.removeFirst();
                    for (int next : adj.get(node)) {
                        if (canVisit[start][next]) {
                            continue;
                        }
                        canVisit[start][next] = true;
                        queue.offerLast(next);
                    }
                }
            }
            int answer = 0;
            for (int target = 1; target <= n; target++) {
                // 다른 모드 노드가 도착 가능하거나
                // 목표 노드에서 그 노드로 갈 수 있어야 함
                boolean knowAllNodes = true;
                for (int other = 1; other <= n; ++other) {
                    if (!canVisit[other][target] && !canVisit[target][other]) {
                        knowAllNodes = false;
                        break;
                    }
                }
                if (knowAllNodes) {
                    answer += 1;
                }
            }
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}