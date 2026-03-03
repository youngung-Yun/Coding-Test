import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int[] sports = new int[n];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                int sport = Integer.parseInt(stk.nextToken());
                sports[i] = sport;
            }
            int[] costs = new int[m];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < m; i++) {
                costs[i] = Integer.parseInt(stk.nextToken());
            }

            int[] choose = new int[n];
            for (int cost : costs) {
                for (int i = 0; i < n; i++) {
                    if (cost >= sports[i]) {
                        ++choose[i];
                        break;
                    }
                }
            }

            int maxIdx = 0;
            for (int i = 0; i < n; i++) {
                if (choose[i] > choose[maxIdx]) {
                    maxIdx = i;
                }
            }
            sb.append('#').append(testcase).append(' ')
                    .append(maxIdx + 1).append('\n');
        }
        System.out.println(sb);
    }
}