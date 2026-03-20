import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int d = 0; d <= arr[curr]; d++) {
                int next = curr + d;
                if (next >= n || distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[curr] + 1;
                queue.offer(next);
            }
        }
        System.out.println(distance[n-1]);
    }
}