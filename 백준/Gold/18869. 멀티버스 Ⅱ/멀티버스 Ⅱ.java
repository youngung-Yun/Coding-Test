import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[][] compressions = new int[m][n];
        for (int uni = 0; uni < m; uni++) {
            stk = new StringTokenizer(bf.readLine());
            int[] planets = new int[n];
            for (int i = 0; i < n; i++) {
                planets[i] = Integer.parseInt(stk.nextToken());
            }
            compressions[uni] = compress(planets, n);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int k = i + 1; k < m; k++) {
                if (isSymmetric(compressions[i], compressions[k], n)) {
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }

    private static int[] compress(int[] arr, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int e : arr) {
            set.add(e);
        }
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : set) {
            map.put(e, rank++);
        }

        int[] compression = new int[n];
        for (int i = 0; i < n; i++) {
            compression[i] = map.get(arr[i]);
        }
        return compression;
    }

    private static boolean isSymmetric(int[] arr1, int[] arr2, int n) {
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}