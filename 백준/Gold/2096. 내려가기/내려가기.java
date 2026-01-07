import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] minDp = new int[n][3];
        int[][] maxDp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            minDp[0][i] = board[0][i];
            maxDp[0][i] = board[0][i];
        }
        for (int i = 1; i < n; i++) {
            minDp[i][0] = Integer.min(minDp[i-1][0], minDp[i-1][1]) + board[i][0];
            maxDp[i][0] = Integer.max(maxDp[i-1][0], maxDp[i-1][1]) + board[i][0];

            minDp[i][1] = Integer.min(minDp[i-1][0], Integer.min(minDp[i-1][1], minDp[i-1][2])) + board[i][1];
            maxDp[i][1] = Integer.max(maxDp[i-1][0], Integer.max(maxDp[i-1][1], maxDp[i-1][2])) + board[i][1];

            minDp[i][2] = Integer.min(minDp[i-1][1], minDp[i-1][2]) + board[i][2];
            maxDp[i][2] = Integer.max(maxDp[i-1][1], maxDp[i-1][2]) + board[i][2];
        }

        int min = 900_001;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            min = Integer.min(min, minDp[n-1][i]);
            max = Integer.max(max, maxDp[n-1][i]);
        }

        System.out.println(max + " " + min);
    }

}