import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntUnaryOperator;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, IntUnaryOperator> commandMap = new HashMap<>();
        commandMap.put("D", (n) -> (n * 2) % 10_000);
        commandMap.put("S", (n) -> n > 0 ? n - 1 : 9_999);
        commandMap.put("L", (n) -> {
            int left = n / 1_000;
            n %= 1_000;
            n = (n * 10) + left;
            return n;
        });
        commandMap.put("R", (n) -> {
            int right = n % 10;
            n = (n / 10) + (right * 1_000);
            return n;
        });


        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int init = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            String[] counts = new String[10_000];

            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(init);
            counts[init] = "";
            while (counts[finish] == null && !queue.isEmpty()) {
                int curr = queue.removeFirst();
                for (String command : commandMap.keySet()) {
                    int result = commandMap.get(command).applyAsInt(curr);
                    if (counts[result] != null) {
                        continue;
                    }
                    counts[result] = counts[curr] + command;
                    queue.offerLast(result);
                }
            }
            sb.append(counts[finish]).append('\n');
        }
        System.out.println(sb.toString());
    }
}

