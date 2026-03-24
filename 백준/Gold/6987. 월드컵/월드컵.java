import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean impossible;
    static boolean possibleResult;
    static int[][] games = new int[15][2];
    static int[][] results = new int[6][3];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < 6; i++) {
            for (int k = i + 1; k < 6; k++) {
                if (i == k) {
                    continue;
                }
                games[idx] = new int[] {i, k};
                ++idx;
            }
        }

        for (int i = 0; i < 4; i++) {
            impossible = false;
            possibleResult = false;
            int totalDraw = 0;
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < 6; c++) {
                int win = Integer.parseInt(stk.nextToken());
                int draw = Integer.parseInt(stk.nextToken());
                int lose = Integer.parseInt(stk.nextToken());
                results[c] = new int[] {win, draw, lose};
                totalDraw += draw;
            }

            if (totalDraw % 2 == 1) {
                impossible = true;
            }
            for (int[] result : results) {
                if (result[0] + result[1] + result[2] != 5) {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                sb.append(0).append(' ');
                continue;
            }

            backtrack(0);
            sb.append(possibleResult ? 1 : 0).append(' ');
        }
        System.out.println(sb);
    }

    // 0=무승부, 1=왼쪽이 승리, 2=오른쪽이 승리
    static void backtrack(int depth) {
        if (possibleResult) {
            return;
        }

        if (depth == 15) {
            for (int[] result : results) {
                if (result[0] > 0 || result[1] > 0 || result[2] > 0) {
                    return;
                }
            }
            possibleResult = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int a = games[depth][0];
            int b = games[depth][1];
            if (i == 0) {
                --results[a][1];
                --results[b][1];
                if (results[a][1] >= 0 && results[b][1] >= 0) {
                    backtrack(depth + 1);
                }
                ++results[a][1];
                ++results[b][1];

            } else if (i == 1) {
                --results[a][0];
                --results[b][2];
                if (results[a][0] >= 0 && results[b][2] >= 0) {
                    backtrack(depth + 1);
                }
                ++results[a][0];
                ++results[b][2];
            } else {
                --results[a][2];
                --results[b][0];
                if (results[a][2] >= 0 && results[b][0] >= 0) {
                    backtrack(depth + 1);
                }
                ++results[a][2];
                ++results[b][0];
            }
        }
    }
}