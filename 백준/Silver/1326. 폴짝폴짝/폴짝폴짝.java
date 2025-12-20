import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] counts = new int[n + 1];
        Arrays.fill(counts, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(a);
        counts[a] = 0;

        while (counts[b] == -1 && !queue.isEmpty()) {
            int curr = queue.removeFirst();
            int distance = array[curr];

            for (int i = curr - distance; i > 0; i -= distance) {
                if (counts[i] == -1) {
                    counts[i] = counts[curr] + 1;
                    queue.offerLast(i);
                }
            }

            for (int i = curr + distance; i <= n; i += distance) {
                if (counts[i] == -1) {
                    counts[i] = counts[curr] + 1;
                    queue.offerLast(i);
                }
            }
        }
        System.out.println(counts[b]);
    }
}
