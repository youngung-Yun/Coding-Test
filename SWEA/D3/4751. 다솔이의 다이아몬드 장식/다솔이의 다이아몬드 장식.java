import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        int[][] around = new int[][] { {-2, 0}, {-1, -1}, {-1, 1}, {0, -2}, {0, 2}, {1, -1}, {1, 1}, {2, 0}};
        for (int t = 1; t <= testCase; t++) {
            String word = br.readLine();
            int len = word.length();
            char[][] array = new char[5][(5 * len) - (len - 1)];
            for (char[] row : array) {
                Arrays.fill(row, '.');
            }
            int idx = 0;
            for (int y = 2; y < array[0].length; y += 4) {
                int x = 2;
                array[x][y] = word.charAt(idx);
                ++idx;
                for (int[] dir : around) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    array[nx][ny] = '#';
                }
            }
            for (int r = 0; r < array.length; r++) {
                for (int c = 0; c < array[0].length; c++) {
                    sb.append(array[r][c]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}