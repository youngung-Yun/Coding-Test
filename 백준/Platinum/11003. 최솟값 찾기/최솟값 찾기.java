import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] minList = new int[n];

        Deque<int[]> deque = new ArrayDeque<>();
        // [index, value]
        deque.addLast(new int[]{0, list[0]});
        minList[0] = deque.peekFirst()[1];

        for (int i = 1; i < n; i++) {
            // 윈도우 이동하여 왼쪽 끝 요소 제거
            if (!deque.isEmpty() && deque.peekFirst()[0] < i - l + 1) {
                deque.pollFirst();
            }
            // 새로 윈도우에 들어올 요소가 후보보다 작거나 같으면, 그 후보는 윈도우에 있을 때
            // 절대 최솟값이 될 수 없으므로 제거
            // 새로운 요소가 후보보다 크면, 그 후보가 윈도우에서 나온 후 그 요소가 최솟값이 될 가능성 있음
            while (!deque.isEmpty() && deque.peekLast()[1] > list[i]) {
                deque.pollLast();
            }
            deque.addLast(new int[]{i, list[i]});

            minList[i] = deque.peekFirst()[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int number : minList) {
            sb.append(number).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}