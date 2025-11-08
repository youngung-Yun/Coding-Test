import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sumList = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumList[i] = sumList[i - 1] + list[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            sb.append(sumList[end] - sumList[start - 1]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}