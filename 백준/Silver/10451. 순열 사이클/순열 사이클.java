import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            int[] seq = new int[n+1];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                seq[i] = Integer.parseInt(stk.nextToken());
            }

            int count = 0;
            boolean[] visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                ++count;
                visited[i] = true;
                int curr = seq[i];
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = seq[curr];
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}