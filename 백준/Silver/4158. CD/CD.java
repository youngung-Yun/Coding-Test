import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int[] sanggeun = new int[n];
            for (int i = 0; i < n; i++) {
                sanggeun[i] = Integer.parseInt(br.readLine());
            }
            int[] sunyoung = new int[m];
            for (int i = 0; i < m; i++) {
                sunyoung[i] = Integer.parseInt(br.readLine());
            }
            int sanggeunIndex = 0;
            int sunyoungIndex = 0;
            int result = 0;
            while (sanggeunIndex < n && sunyoungIndex < m) {
                int cd1 = sanggeun[sanggeunIndex];
                int cd2 = sunyoung[sunyoungIndex];

                if (cd1 == cd2) {
                    ++result;
                    ++sanggeunIndex;
                    ++sunyoungIndex;
                } else if (cd1 < cd2) {
                    ++sanggeunIndex;
                } else {
                    ++sunyoungIndex;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}