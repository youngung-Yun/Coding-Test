import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 0; testCase < t; ++testCase) {
            int n = sc.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = sc.nextInt();
            }

            StringBuilder sb = new StringBuilder();

            // 중앙값의 오른쪽 (중앙값보다 큰 값들)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            // 중앙값의 왼쪽 (중앙값과 같거나 작은 값들)
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int e = sequence[i];

                if (minHeap.size() == maxHeap.size()) {
                    maxHeap.add(e);
                } else {
                    minHeap.add(e);
                }

                // swap
                if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                    int val1 = minHeap.poll();
                    int val2 = maxHeap.poll();
                    minHeap.add(val2);
                    maxHeap.add(val1);
                }

                // 홀수번째
                if ((i + 1) % 2 == 1) {
                    list.add(maxHeap.peek());
                    ++count;
                }
            }
            sb.append(count).append('\n');
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(' ');
                if ((i + 1) % 10 == 0 && i + 1 < list.size()) {
                    sb.append('\n');
                }
            }
            System.out.println(sb);
        }
    }
}