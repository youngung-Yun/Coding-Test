import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacency.get(a).add(b);
            adjacency.get(b).add(a);
        }
        int[] counts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] numbers = new int[n+1];
            Arrays.fill(numbers, -1);
            Deque<Integer> queue = new ArrayDeque<>();
            numbers[i] = 0;
            queue.offerLast(i);
            while (!queue.isEmpty()) {
                int curr = queue.removeFirst();
                for (int friend : adjacency.get(curr)) {
                    if (numbers[friend] != -1) {
                        continue;
                    }
                    queue.offerLast(friend);
                    numbers[friend] = numbers[curr] + 1;
                }
            }
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += numbers[j];
            }
            counts[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Integer.min(min, counts[i]);
        }
        for (int i = 1; i <= n; i++) {
            int count = counts[i];
            if (count == min) {
                System.out.println(i);
                break;
            }
        }
    }
}

