import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                matrix[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] correct = new int[n];
        for (int predict = 1; predict < matrix[0][1]; predict++) {
            int other = matrix[0][1] - predict;
            boolean isCorrect = true;
            for (int i = 2; i < n; i++) {
                if (matrix[0][i] - predict != matrix[1][i] - other) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                correct[0] = predict;
                for (int i = 1; i < n; i++) {
                    correct[i] = matrix[0][i] - predict;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int e : correct) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}