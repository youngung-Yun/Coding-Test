import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] seq;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(bf.readLine());
        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(seq);

        backtracking(new int[m], 0, 0);
        System.out.println(sb);
    }

    private static void backtracking(int[] arr, int depth, int id) {
        if (depth == m) {
            StringBuilder tmp = new StringBuilder();
            for (int e : arr) {
                tmp.append(e).append(' ');
            }
            tmp.append('\n');
            if (!set.contains(tmp.toString())) {
                set.add(tmp.toString());
                sb.append(tmp);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = seq[i];
            backtracking(arr, depth + 1, (id * 10 + i));
        }
    }
}