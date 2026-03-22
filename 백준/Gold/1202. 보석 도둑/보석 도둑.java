import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        // 무게 오름차순
        PriorityQueue<int[]> jewels = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[0], a2[0]));
        // 가격 내림차순
        PriorityQueue<int[]> mostValuable = new PriorityQueue<>((a1, a2) -> Integer.compare(a2[1], a1[1]));

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int mass = Integer.parseInt(stk.nextToken());
            int value = Integer.parseInt(stk.nextToken());
            jewels.add(new int[] {mass, value});
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(bags);

        long ans = 0L;
        int idx = 0;
        while (idx < k) {
            int bag = bags[idx];
            ++idx;
            while (!jewels.isEmpty() && jewels.peek()[0] <= bag) {
                mostValuable.add(jewels.poll());
            }
            if (mostValuable.isEmpty()) {
                continue;
            }
            ans += mostValuable.poll()[1];
        }
        System.out.println(ans);
    }

}