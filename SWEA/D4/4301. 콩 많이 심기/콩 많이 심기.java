import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int col = Integer.parseInt(stk.nextToken());
            int row = Integer.parseInt(stk.nextToken());

            int ans = 0;
            int[][] farm = new int[row][col];
            // 첫 행에는 2개씩 띄어 심기
            for (int c = 0; c < col; c++) {
                if (c % 4 < 2) {
                    farm[0][c] = 1;
                    ++ans;
                }
            }

            for (int r = 1; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if ((r-2 < 0 || farm[r-2][c] == 0) && (c - 2 < 0 || farm[r][c-2] == 0)) {
                        farm[r][c] = 1;
                        ++ans;
                    }
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}