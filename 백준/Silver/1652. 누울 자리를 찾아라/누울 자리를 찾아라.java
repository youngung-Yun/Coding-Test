import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] room = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = row.charAt(j);
            }
        }

        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < n; i++) {
            int rowLength = 0;
            int colLength = 0;
            for (int j = 0; j <= n; j++) {
                if (j == n || room[i][j] == 'X') {
                    if (rowLength >= 2) {
                        ++rowCount;
                    }
                    rowLength = 0;
                }
                else {
                    ++rowLength;
                }

                if (j == n || room[j][i] == 'X') {
                    if (colLength >= 2) {
                        ++colCount;
                    }
                    colLength = 0;

                }
                else {
                    ++colLength;
                }
            }
        }

        System.out.printf("%d %d\n", rowCount, colCount);
    }
}