import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 각 행에서 가장 높은 박스의 열
        int[] rowMax = new int[n];
        Arrays.fill(rowMax, -1);
        // 각 열에서 가장 높은 박스의 행
        int[] colMax = new int[m];
        Arrays.fill(colMax, -1);
        int[][] boxes = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                int height = Integer.parseInt(stk.nextToken());
                boxes[r][c] = height;
                if (rowMax[r] == -1 || boxes[r][rowMax[r]] < height) {
                    rowMax[r] = c;
                }
                if (colMax[c] == -1 || boxes[colMax[c]][c] < height) {
                    colMax[c] = r;
                }
            }
        }

        long ans = 0L;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rowMax[r] != c && colMax[c] != r) {
                    ans += boxes[r][c];
                }
            }
        }
        System.out.println(ans);
    }

}