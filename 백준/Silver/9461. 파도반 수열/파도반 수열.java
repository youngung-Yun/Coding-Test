import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] array = new long[n + 1];
            for (int k = 1; k <= 5; k++) {
                if (k > n) {
                    break;
                }
                if (k <= 3) {
                    array[k] = 1L;
                } else {
                    array[k] = 2L;
                }
            }
            for (int k = 6; k <= n; k++) {
                array[k] = array[k - 1] + array[k - 5];
            }
            sb.append(array[n]).append('\n');
        }
        System.out.println(sb.toString());

    }
}