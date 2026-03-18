import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> children = new ArrayList<>();
    static int[] value;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            children.get(p).add(c);
        }

        stk = new StringTokenizer(bf.readLine());
        value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(getDp(0));
    }

    // root 및 그의 서브 트리를 모두 방문 또는 방문하지 않았을 때의 최댓값 =
    // 자식 중 합이 양수인 값들의 합 + 나의 값
    private static long getDp(int root) {
        long sum = value[root];
        for (int child : children.get(root)) {
            sum += Long.max(getDp(child), 0L);
        }
        return sum;
    }
}