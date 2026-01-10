import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coordinate = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            coordinate[pos] = amount;
        }
        int total = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            if (i > 1_000_000) {
                break;
            }
            total += coordinate[i];
        }
        int result = total;
        int left = 0;
        int right = 2 * k + 1;
        while (right < 1_000_001) {
            total -= coordinate[left];
            ++left;
            total += coordinate[right];
            ++right;
            result = Integer.max(result, total);
        }
        System.out.println(result);
    }
}