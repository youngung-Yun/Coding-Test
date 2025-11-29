import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
         1. A의 값들을 오름차순 정렬, 값이 같으면 인덱스를 오름차순 정렬
         2. i -> 0 to n일 때, sorted[i]의 원래 인덱스를 ori라 할 때 P[ori]에 i를 넣음
         */

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Node(value, i));
        }

        int[] p = new int[n];
        for (int curr = 0; curr < n; curr++) {
            Node node = pq.poll();
            int index = node.index;
            p[index] = curr;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(p).forEach(e -> sb.append(e).append(' '));
        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node> {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) {
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(this.value, o.value);
        }
    }
}