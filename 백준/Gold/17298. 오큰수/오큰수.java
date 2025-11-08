import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] ngeList = new int[n];

        // [index, value]
        Deque<int[]> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(new int[] {i, number});
                continue;
            }

            while (!stack.isEmpty() && stack.peek()[1] < number) {
                int[] top = stack.pop();
                ngeList[top[0]] = number;
            }

            stack.push(new int[] {i, number});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            ngeList[top[0]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int number : ngeList) {
            sb.append(number).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}