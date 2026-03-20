import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] standard = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            standard[i] = Integer.parseInt(stk.nextToken());
        }

        List<int[]> ans = new ArrayList<>();
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int[] seq = new int[n];
            for (int k = 0; k < n; k++) {
                seq[k] = Integer.parseInt(stk.nextToken());
            }

            if (isSame(standard, seq, n) || isSame(standard, reverse(seq, n), n)) {
                ans.add(seq);
            }
        }

        sb.append(ans.size()).append('\n');
        for (int[] seq : ans) {
            for (int e : seq) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isSame(int[] origin, int[] target, int n) {
        for (int start = 0; start < n; start++) {
            boolean isSame = true;
            for (int i = 0; i < n; i++) {
                int originDir = origin[i];
                int targetDir = target[(start + i) % n];
                if (originDir != targetDir) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return true;
            }
        }
        return false;
    }

    private static int[] reverse(int[] arr, int n) {
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = arr[n-1-i] <= 2 ? arr[n-1-i] + 2 : arr[n-1-i] - 2;
        }
        return reverse;
    }
}