import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    final static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        dfs(new int[m], 0);

        System.out.println(sb);
    }

    private static void dfs(int[] selectNumbers, int depth) {
        if (depth == m) {
            for (int number : selectNumbers) {
                sb.append(number).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            selectNumbers[depth] = arr[i];
            dfs(selectNumbers,depth + 1);
        }
    }
}