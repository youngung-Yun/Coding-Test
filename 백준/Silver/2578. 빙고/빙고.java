import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        // {번호, 좌표}
        Map<Integer, int[]> bingoMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                bingo[i][j] = number;
                bingoMap.put(number, new int[] {i, j});
            }
        }

        int[] numbers = new int[26];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                numbers[i * 5 + j + 1] = number;
            }
        }

        boolean[][] isCalled = new boolean[5][5];
        for (int i = 1; i <= 25; i++) {
            int[] pos = bingoMap.get(numbers[i]);
            isCalled[pos[0]][pos[1]] = true;
            int bingoCount = getBingoCount(isCalled);
            if (bingoCount >= 3) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int getBingoCount(boolean[][] called) {
        int count = 0;
        // 가로, 세로 확인
        for (int i = 0; i < 5; i++) {
            boolean isRowBingo = true;
            boolean isColBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!isRowBingo && !isColBingo) {
                    break;
                }

                if (!called[i][j]) {
                    isRowBingo = false;
                }
                if (!called[j][i]) {
                    isColBingo = false;
                }
            }
            if (isRowBingo) {
                ++count;
            }
            if (isColBingo) {
                ++count;
            }
        }
        // 대각선 확인
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        for (int i = 0; i < 5; i++) {
            if (!leftDiagonal && !rightDiagonal) {
                break;
            }

            if (!called[i][i]) {
                leftDiagonal = false;
            }
            if (!called[i][4 - i]) {
                rightDiagonal = false;
            }
        }
        if (leftDiagonal) {
            ++count;
        }
        if (rightDiagonal) {
            ++count;
        }

        return count;
    }
}