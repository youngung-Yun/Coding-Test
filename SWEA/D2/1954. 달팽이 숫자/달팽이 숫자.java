
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        int[][] directions= new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            int direction = 0;
            int count = 1;
            matrix[0][0] = 1;
            int nx = 0;
            int ny = 0;
            
            while (count < N * N) {
                int dx = nx + directions[direction][0];
                int dy = ny + directions[direction][1];
                
                // 범위 밖
                if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                    direction = (direction + 1) % 4;
                    continue;
                }
                // 막힘
                if (matrix[dx][dy] != 0) {
                    direction = (direction + 1) % 4;
                    continue;
                }
                matrix[dx][dy] = matrix[nx][ny] + 1;
                ++count;
                nx = dx;
                ny = dy;
            }
            
            System.out.printf("#%d\n", test_case);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.printf("%d ", matrix[r][c]);
                }
                System.out.println();
            }
		}
	}
}