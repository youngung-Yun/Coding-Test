import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int k = 0; k < c; k++) {
                map[i][k] = row.charAt(k);
            }
        }

        // 1. 삼면 이상 바다인 섬을 바다로 변경 -> 하나씩 변경하면 안되고 한 번에 변경해야함
        // 2. 가로와 세로 각각의 시작과 끝에서, 모든 열 또는 행이 바다인 수 만큼 지도 크기 줄임
        List<int[]> willBeSunkenIslands = new ArrayList<>();
        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                if (map[i][k] == '.') {
                    continue;
                }
                int boundaryCount = 0;
                for (int[] dir : dirs) {
                    int nx = i + dir[0];
                    int ny = k + dir[1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '.') {
                        // 범위를 벗어나는 곳은 바다임
                        ++boundaryCount;
                    }
                }
                if (boundaryCount >= 3) {
                    willBeSunkenIslands.add(new int[] {i, k});
                }
            }
        }
        // 가라앉음
        for (int[] island : willBeSunkenIslands) {
            map[island[0]][island[1]] = '.';
        }

        int minX = 0;
        for (int i = 0; i < r; i++) {
            boolean canShrink = true;
            for (int k = 0; k < c; k++) {
                if (map[i][k] == 'X') {
                    canShrink = false;
                    break;
                }
            }
            if (canShrink) {
                ++minX;
            } else {
                break;
            }
        }
        int maxX = r - 1;
        for (int i = r - 1; i >= 0; i--) {
            boolean canShrink = true;
            for (int k = 0; k < c; k++) {
                if (map[i][k] == 'X') {
                    canShrink = false;
                    break;
                }
            }
            if (canShrink) {
                --maxX;
            } else {
                break;
            }
        }
        int minY = 0;
        for (int k = 0; k < c; k++) {
            boolean canShrink = true;
            for (int i = 0; i < r; i++) {
                if (map[i][k] == 'X') {
                    canShrink = false;
                    break;
                }
            }
            if (canShrink) {
                ++minY;
            } else {
                break;
            }
        }
        int maxY = c - 1;
        for (int k = c - 1; k >= 0; k--) {
            boolean canShrink = true;
            for (int i = 0; i < r; i++) {
                if (map[i][k] == 'X') {
                    canShrink = false;
                    break;
                }
            }
            if (canShrink) {
                --maxY;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int k = minY; k <= maxY; k++) {
                sb.append(map[i][k]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}