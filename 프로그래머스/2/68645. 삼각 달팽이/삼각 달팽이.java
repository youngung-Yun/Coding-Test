import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] array = new int[n][n];
        int x = 0;
        int y = 0;
        int number = 1;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                while (true) {
                    array[x][y] = number;
                    ++number;
                    if (x + 1 >= n || array[x+1][y] != 0) {
                        ++y;
                        break;
                    }
                    ++x;
                }
            } else if (i % 3 == 1) {
                while (true) {
                    array[x][y] = number;
                    ++number;
                    if (y + 1 >= n || array[x][y+1] != 0) {
                        --x;
                        --y;
                        break;
                    }
                    ++y;
                }
            } else {
                while (true) {
                    array[x][y] = number;
                    ++number;
                    if (array[x-1][y-1] != 0) {
                        ++x;
                        break;
                    }
                    --x;
                    --y;
                }
            }
        }
        int[] answer = new int[(n * (n + 1)) / 2];
        int idx = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r + 1; c++) {
                answer[idx] = array[r][c];
                ++idx;
            }
        }
        return answer;
    }
}