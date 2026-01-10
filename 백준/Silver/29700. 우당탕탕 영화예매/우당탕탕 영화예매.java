import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k > m) {
            System.out.println(0);
            return;
        }
        char[][] seats = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                seats[i][j] = row.charAt(j);
            }
        }
        int result = 0;
        for (int row = 0; row < n; row++) {
            int emptySeatCount = 0;
            // init
            for (int j = 0; j < k; j++) {
                if (seats[row][j] == '0') {
                    ++emptySeatCount;
                }
            }
            if (emptySeatCount == k) {
                ++result;
            }
            int left = 0;
            int right = k;
            while (right < m) {
                if (seats[row][left] == '0') {
                    --emptySeatCount;
                }
                ++left;
                if (seats[row][right] == '0') {
                    ++emptySeatCount;
                }
                ++right;
                if (emptySeatCount == k) {
                    ++result;
                }
            }
        }
        System.out.println(result);
    }
}