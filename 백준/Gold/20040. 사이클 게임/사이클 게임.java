import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        parents = IntStream.rangeClosed(0, n).toArray();

        int[][] turns = new int[m][2];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            turns[i] = new int[] {a, b};
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] turn = turns[i];
            int a = turn[0];
            int b = turn[1];

            if (!union(a, b)) {
                ans = i + 1;
                break;
            }
        }

        System.out.println(ans);
    }

    private static int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    private static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false;
        }

        int min = Integer.min(parentX, parentY);
        int max = Integer.max(parentX, parentY);
        parents[max] = min;
        return true;
    }
}
