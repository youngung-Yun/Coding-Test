import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            arr[i] = new int[] {start, end};
        }

        Arrays.sort(arr, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        int ans = 0;
        int curr = 0;
        for (int[] water : arr) {
            curr = Integer.max(water[0], curr);
            while (curr < water[1]) {
                ++ans;
                curr += l;
            }
        }

        System.out.println(ans);
    }
}
