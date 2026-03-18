import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        long[] ink = new long[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            ink[i] = Long.parseLong(stk.nextToken());
        }
        long[] viscosity = new long[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            viscosity[i] = Long.parseLong(stk.nextToken());
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // i ~ n에서 점도가 ink[i]보다 큰 첫 번째 요소
            int low = i + 1;
            int high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (viscosity[mid] > ink[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = (low - 1 - i);
        }

        StringBuilder sb = new StringBuilder();
        for (int e : ans) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}