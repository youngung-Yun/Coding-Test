import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            int t = Integer.parseInt(br.readLine());

            int[][] ladder = new int[100][100];
            int dest = 0;
            for (int r = 0; r < 100; r++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int c = 0; c < 100; c++) {
                    int e = Integer.parseInt(token.nextToken());
                    ladder[r][c] = e;
                    if (e == 2) {
                        dest = c;
                    }
                }
            }

            int x = dest;
            for (int r = 100 - 1; r >= 0; r--) {
                // 왼쪽이나 오른쪽에 길 있으면 이동한후 위로 이동하기
                if (x - 1 >= 0 && ladder[r][x-1] == 1) {
                    // 왼쪽으로 계속 이동
                    while (x - 1 >= 0 && ladder[r][x-1] == 1) {
                        x -= 1;
                    }
                } else if (x + 1 < 100 && ladder[r][x+1] == 1) {
                    // 오른으로 계속 이동
                    while (x + 1 < 100 && ladder[r][x+1] == 1) {
                        x += 1;
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(x).append('\n');
        }
        System.out.println(sb);
    }

}