import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] time = { 300, 60, 10 };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] ans = new int[3];
        for (int i = 0; i < 3; i++) {
            ans[i] += (n / time[i]);
            n %= time[i];
        }

        if (n != 0) {
            System.out.println(-1);
        } else {
            for (int e : ans) {
                System.out.printf("%d ", e);
            }
        }
    }
}