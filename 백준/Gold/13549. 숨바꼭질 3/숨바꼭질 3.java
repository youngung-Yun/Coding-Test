import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int chaser = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] distance = new int[100_001];
        Arrays.fill(distance, 100_001);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(chaser);
        distance[chaser] = 0;
        while (distance[target] == 100_001) {
            int current = queue.removeFirst();
            if (current > 0) {
                for (int i = current * 2; i <= 100_000; i *= 2) {
                    if (distance[i] > distance[current]) {
                        distance[i] = distance[current];
                        queue.offerLast(i);
                    }
                }
            }

            if (current - 1 >= 0 && distance[current-1] > distance[current] + 1) {
                distance[current-1] = distance[current] + 1;
                queue.offerLast(current-1);
            }
            if (current + 1 <= 100_000 && distance[current+1] > distance[current] + 1) {
                distance[current+1] = distance[current] + 1;
                queue.offerLast(current+1);
            }
        }
        System.out.println(distance[target]);
    }
}