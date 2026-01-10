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
        int[][] claps = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                claps[i][j] = Integer.parseInt(row[j]);
            }
        }
        int a = Integer.parseInt(br.readLine());

        // init
        int total = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < n; j++) {
                total += claps[j][i];
            }
        }
        int result = total;
        for (int i = a; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total -= claps[j][i-a];
                total += claps[j][i];
            }
            result = Integer.max(result, total);
        }
        System.out.println(result);
    }
}