import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            int[] diamonds = new int[n];
            for (int i = 0; i < n; i++) {
                diamonds[i] = Integer.parseInt(bf.readLine());
            }

            Arrays.sort(diamonds);

            // 정렬했을 때 left와 righ의 차가 k 이하인 부분 수열의 최대 길이
            int ans = 0;
            int left = 0;
            for (int right = 1; right < n; right++) {
                while (diamonds[right] - diamonds[left] > k) {
                    ++left;
                }
                ans = Integer.max(ans, right - left + 1);
            }
            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}