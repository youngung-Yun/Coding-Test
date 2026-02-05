import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(bf.readLine());
            int maxHeight = 0;
            int[] arr = new int[n];
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                int height = Integer.parseInt(token.nextToken());
                arr[i] = height;
                maxHeight = Integer.max(maxHeight, height);
            }

            int oddCount = 0;
            int difference = 0;
            for (int i = 0; i < n; i++) {
                int diff = maxHeight - arr[i];
                oddCount += (diff % 2);
                difference += diff;
            }

            // 홀수 차이 제거
            difference -= (oddCount * 3);

            // 홀수가 더 많으면 마지막 짝수날 제외
            if (difference < 0) {
                sb.append('#').append(testCase).append(' ')
                        .append(oddCount * 2 - 1).append('\n');
                continue;
            }

            int ans = oddCount * 2;
            // 4일씩 묶어 처리
            ans += (difference / 6) * 4;
            difference %= 6;
            // 2 남으면 홀수날 생략 후 짝수날에 물 주기
            if (difference == 2) {
                ans += 2;
            // 4 남으면 마지막 짝수날 제외
            } else if (difference == 4) {
                ans += 3;
            }
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}