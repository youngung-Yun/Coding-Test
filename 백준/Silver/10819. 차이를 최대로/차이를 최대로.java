import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int max = -801;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(array, new int[n], new boolean[n], 0, n);

        System.out.println(max);
    }

    private static void dfs(int[] array, int[] newArray, boolean[] visited, int depth, int n) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(newArray[i + 1] - newArray[i]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            newArray[depth] = array[i];
            visited[i] = true;
            dfs(array, newArray, visited, depth + 1, n);
            visited[i] = false;
        }
    }
}