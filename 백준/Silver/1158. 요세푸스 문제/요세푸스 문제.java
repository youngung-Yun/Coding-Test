import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offerLast(i);
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            ++count;
            int removed = queue.removeFirst();
            if (count == k) {
                result.add(removed);
                count = 0;
                continue;
            }
            queue.offerLast(removed);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('>');
        System.out.println(sb);
    }
}