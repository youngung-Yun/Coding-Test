import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] candies;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        candies = new char[n][n];
        for (int r = 0; r < n; r++) {
            String row = br.readLine();
            for (int c = 0; c < n; c++) {
                candies[r][c] = row.charAt(c);
            }
        }
        // 1. 주변 사방의 사탕들과 위치를 바꿈
        // 2. 바꾼 두 사탕 기준으로 사방에 가장 긴 연속되는 사탕의 길이를 구함
        int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int longestCandies = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // 근처 사탕 선택하기
                for (int[] dir : dirs) {
                    int ox = x + dir[0];
                    int oy = y + dir[1];
                    if (ox < 0 || oy < 0 || ox >= n || oy >= n) {
                        continue;
                    }
                    // 사탕 위치 변경
                    swapCandy(candies, x, y, ox, oy);

                    char curr = candies[x][y];
                    int horizontalLength = 1;
                    int verticalLength = 1;
                    for (int k = 0; k < dirs.length; k++) {
                        int[] d = dirs[k];
                        int nx = x + d[0];
                        int ny = y + d[1];
                        while (nx >= 0 && ny >= 0 && nx < n && ny < n && curr == candies[nx][ny]) {
                            nx += d[0];
                            ny += d[1];
                            if (k <= 1) {
                                verticalLength++;
                            } else {
                                horizontalLength++;
                            }
                        }
                        longestCandies = Integer.max(longestCandies, Integer.max(horizontalLength, verticalLength));
                    }

                    curr = candies[ox][oy];
                    horizontalLength = 1;
                    verticalLength = 1;
                    for (int k = 0; k < dirs.length; k++) {
                        int[] d = dirs[k];
                        int nx = ox + d[0];
                        int ny = oy + d[1];
                        while (nx >= 0 && ny >= 0 && nx < n && ny < n && curr == candies[nx][ny]) {
                            nx += d[0];
                            ny += d[1];
                            if (k <= 1) {
                                verticalLength++;
                            } else {
                                horizontalLength++;
                            }
                        }

                        longestCandies = Integer.max(longestCandies, Integer.max(horizontalLength, verticalLength));
                    }
                    swapCandy(candies, x, y, ox, oy);
                }
            }
        }
        System.out.println(longestCandies);
    }

    static void swapCandy(char[][] candies, int x1, int y1, int x2, int y2) {
        char tmp = candies[x2][y2];
        candies[x2][y2] = candies[x1][y1];
        candies[x1][y1] = tmp;
    }
}