import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // (A - B) % M == 0이면 A % M == B % M
        // (Sj - Si-1) % M == 0이면 Sj % M == Si-1 % M

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sumList = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sumList[i] = (sumList[i - 1] + Integer.parseInt(st.nextToken())) % m;
        }

        Map<Integer, Integer> remainderMap = new HashMap<>();
        for (int sum : sumList) {
            int count = remainderMap.getOrDefault(sum, 0);
            remainderMap.put(sum, count + 1);
        }

        long count = 0;
        for (int value : remainderMap.values()) {
            count += (long) (value - 1) * value / 2;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}