import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new long[] {i, ((long) n - i) * (i + 1)};
        }

        Arrays.sort(arr, (a1, a2) -> {
            return Long.compare(a2[1], a1[1]);
        });

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long e = n - i;
            ans[(int) arr[i][0]] = e;
        }

        StringBuilder sb = new StringBuilder();
        for (long e : ans) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }

}