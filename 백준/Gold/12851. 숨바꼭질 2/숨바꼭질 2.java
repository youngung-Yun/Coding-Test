import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MIN = 0;
    final static int MAX = 100_000 * 2;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int chaser = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(chaser);
        int[] time = new int[MAX+1];
        Arrays.fill(time, MAX);
        time[chaser] = 0;

        int[] visitedCount = new int[MAX+1];
        visitedCount[chaser] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == target) {
                continue;
            }

            if (now + 1 <= MAX && time[now] + 1 <= time[now+1]) {
                // 기존 위치 경우의 수 더함
                visitedCount[now+1] += visitedCount[now];
                // 최소 도착 시간 갱신
                time[now+1] = Integer.min(time[now+1], time[now] + 1);
                // 첫 도착시 큐에 넣음
                if (visitedCount[now+1] == visitedCount[now]) {
                    queue.offer(now + 1);
                }
            }
            if (now - 1 >= MIN && time[now] + 1 <= time[now-1]) {
                visitedCount[now-1] += visitedCount[now];
                time[now-1] = Integer.min(time[now-1], time[now] + 1);
                if (visitedCount[now-1] == visitedCount[now]) {
                    queue.offer(now - 1);
                }
            }
            if (now * 2 <= MAX && time[now] + 1 <= time[now*2]) {
                visitedCount[now*2] += visitedCount[now];
                time[now*2] = Integer.min(time[now*2], time[now] + 1);
                if (visitedCount[now*2] == visitedCount[now]) {
                    queue.offer(now * 2);
                }
            }
        }

        System.out.println(time[target]);
        System.out.println(visitedCount[target]);
    }
}