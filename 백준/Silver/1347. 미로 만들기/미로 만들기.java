import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String map = br.readLine();

        // 남, 서, 북, 동
        int[][] dirs = new int[][] { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        int direction = 0;
        int x = 0;
        int y = 0;
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;
        List<int[]> visitedPos = new ArrayList<>(); // 방문한 칸들의 오프셋 저장
        visitedPos.add(new int[] {0, 0});
        // L이나 R은 방향 변경 / L = -, R = +
        // 이동시 시작 위치 기준 x와 y 오프셋 저장
        // minOffset + maxOffset 가 행 또는 열의 길이
        for (char ch : map.toCharArray()) {
            if (ch == 'R') {
                direction = (direction + 1) % 4;
            } else if (ch == 'L') {
                direction = (direction + 3) % 4;
            } else {
                x += dirs[direction][0];
                y += dirs[direction][1];
                visitedPos.add(new int[] {x, y});
                minX = Integer.min(minX, x);
                minY = Integer.min(minY, y);
                maxX = Integer.max(maxX, x);
                maxY = Integer.max(maxY, y);
            }
        }

        int startX = -minX;
        int startY = -minY;
        char[][] maze = new char[maxX-minX+1][maxY-minY+1];
        for (char[] row : maze) {
            Arrays.fill(row, '#');
        }
        for (int[] pos: visitedPos) {
            maze[startX + pos[0]][startY + pos[1]] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : maze) {
            for (char col : row) {
                sb.append(col);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}