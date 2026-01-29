import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");

            sb.append('#').append(testCase).append(' ');
            int half = (n + 1) / 2;
            for (int i = 0; i < half; i++) {
                sb.append(cards[i]).append(' ');
                if (half + i < n) {
                    sb.append(cards[half+i]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}