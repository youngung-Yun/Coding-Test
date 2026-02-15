import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());

            List<Integer> fibo = getFibo(n);
            List<Integer> ans = new ArrayList<>();
            int[] largest = {0, fibo.size() - 1};
            while (n > 0) {
                largest = getLargestFibo(fibo, n, largest[1]);
                ans.add(largest[0]);
                n -= largest[0];
            }

            for (int k = ans.size() - 1; k >= 0; k--) {
                sb.append(ans.get(k)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static List<Integer> getFibo(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        while (list.get(list.size() - 1) +  list.get(list.size() - 2) <= n) {
            list.add(list.get(list.size() - 1) +  list.get(list.size() - 2));
        }

        return list;
    }

    static int[] getLargestFibo(List<Integer> fibo, int target, int idx) {
        int curr = fibo.get(idx);
        while (curr > target) {
            --idx;
            curr = fibo.get(idx);
        }

        return new int[] {curr, idx};
    }

}