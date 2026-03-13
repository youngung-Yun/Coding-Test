import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = 200_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int chaser = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        int[] distance = new int[MAX+1];
        Arrays.fill(distance, MAX);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(chaser);
        distance[chaser] = 0;

        while (!deque.isEmpty()) {
            int now = deque.removeFirst();
            if (now > 0) {
                for (int next = now * 2; next <= MAX; next *= 2) {
                    if (distance[next] > distance[now]) {
                        distance[next] = distance[now];
                        deque.offerFirst(next);
                    }
                }
            }

            if (now > 0 && distance[now-1] > distance[now] + 1) {
                distance[now-1] = distance[now] + 1;
                deque.offerLast(now - 1);
            }
            if (now < MAX && distance[now+1] > distance[now] + 1) {
                distance[now+1] = distance[now] + 1;
                deque.offerLast(now + 1);
            }
        }

        System.out.println(distance[target]);
    }
}

