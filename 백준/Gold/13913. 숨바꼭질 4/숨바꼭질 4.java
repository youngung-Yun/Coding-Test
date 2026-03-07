import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MIN = 0;
    final static int MAX = 100_000;

    final static int INIT = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int chaser = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        int[] prev = new int[MAX+1];
        Arrays.fill(prev, INIT);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(chaser);
        prev[chaser] = chaser;

        int count = 0;
        List<Integer> seq = new ArrayList<>();
        while (!queue.isEmpty() && count == 0) {
            int now = queue.poll();

            if (now == target) {
                while (now != chaser) {
                    ++count;
                    seq.add(now);
                    now = prev[now];
                }
                seq.add(chaser);
                break;
            }

            if (now + 1 <= MAX && prev[now+1] == INIT) {
                int next = now + 1;
                prev[next] = now;
                queue.offer(next);
            }
            if (now - 1 >= MIN && prev[now-1] == INIT) {
                int next = now - 1;
                prev[next] = now;
                queue.offer(next);
            }
            if (now * 2 <= MAX&& prev[now*2] == INIT) {
                int next = now * 2;
                prev[next] = now;
                queue.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int i = seq.size() - 1; i >= 0; i--) {
            sb.append(seq.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}