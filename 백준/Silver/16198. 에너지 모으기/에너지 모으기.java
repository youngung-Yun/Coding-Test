import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;
    static List<Integer> energies;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        energies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            energies.add(Integer.parseInt(stk.nextToken()));
        }

        dfs(new int[n - 2], 0, n);

        System.out.println(ans);
    }

    private static void dfs(int[] arr, int depth, int limit) {
        if (depth == limit - 2) {
            computeEnergy(arr);
            return;
        }

        // 인덱스 범위 [1, limit-depth-1]
        for (int i = 1; i < limit - depth - 1; i++) {
            arr[depth] = i;
            dfs(arr, depth + 1, limit);
        }
    }

    private static void computeEnergy(int[] arr) {
        List<Integer> copy = new ArrayList<>(energies);
        int total = 0;
        for (int idx : arr) {
            total += (copy.get(idx-1) * copy.get(idx+1));
            copy.remove(idx);
        }
        ans = Integer.max(ans, total);
    }
}