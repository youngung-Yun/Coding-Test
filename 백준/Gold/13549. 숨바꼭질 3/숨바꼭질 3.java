import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = -1;
    final static int MAX = 200_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int chaser = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        int[] distance = new int[MAX+1];
        Arrays.fill(distance, INF);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {chaser, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int coord = now[0];
            int d = now[1];

            if (distance[coord] != INF) {
                continue;
            }
            // 큐에서 꺼낼 때 최단경로 확정
            distance[coord] = d;
            if (coord == target) {
                break;
            }

            if (coord > 0) {
                for (int next = coord * 2; next <= MAX; next *= 2) {
                    if (distance[next] == INF) {
                        deque.offerFirst(new int[] {next, d});
                    }
                }
            }

            if (coord > 0 && distance[coord-1] == INF) {
                deque.offerLast(new int[] {coord - 1, d + 1});
            }
            if (coord < MAX && distance[coord+1] == INF) {
                deque.offerLast(new int[] {coord + 1, d + 1});
            }
        }

        System.out.println(distance[target]);
    }
}

