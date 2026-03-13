import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 100_001;
    final static int MAX = 200_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int chaser = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        int[] distance = new int[MAX+1];
        Arrays.fill(distance, INF);
        distance[chaser] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {chaser, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int coord = now[0];
            int d = now[1];

            if (coord > 0) {
                for (int next = coord * 2; next <= MAX; next *= 2) {
                    if (distance[next] > d) {
                        deque.offerFirst(new int[] {next, d});
                        distance[next] = d;
                    }
                }
            }
            if (coord > 0 && distance[coord-1] > d) {
                deque.offerLast(new int[] {coord - 1, d + 1});
                distance[coord-1] = d + 1;
            }
            if (coord < MAX && distance[coord+1] > d) {
                deque.offerLast(new int[] {coord + 1, d + 1});
                distance[coord+1] = d + 1;
            }
        }
        System.out.println(distance[target]);
    }
}

