
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int[] top;
    static int[] bottom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        boolean hasFoundAirFurifier = false;

        int[][] room = new int[r][c];
        for (int row = 0; row < r; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < c; col++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1 && !hasFoundAirFurifier) {
                    // 공기청정기 위치 저장
                    top = new int[] {row, col};
                    bottom = new int[] {row+1, col};
                    hasFoundAirFurifier = true;
                }
                room[row][col] = num;
            }
        }

        for (int i = 0; i < t; i++) {
            spreadDust(room, r, c);
            runAirFurifierTop(room, r, c);
            runAirFurifierBottom(room, r, c);

        }

        int total = 2;
        for (int row = 0; row < r; ++row) {
            for (int col = 0; col < c; ++col) {
                total += room[row][col];
            }
        }
        System.out.println(total);
    }

    static void runAirFurifierTop(int[][] room, int r, int c) {
        int x = top[0];
        int y = top[1] + 1;
        int now = room[x][y];
        room[x][y] = 0;
        // 오른쪽으로
        while (y < c - 1) {
            int tmp = room[x][y+1];
            room[x][y+1] = now;
            now = tmp;
            ++y;
        }
        // 위로
        while (x > 0) {
            int tmp = room[x-1][y];
            room[x-1][y] = now;
            now = tmp;
            --x;
        }
        // 왼쪽으로
        while (y > 0) {
            int tmp = room[x][y-1];
            room[x][y-1] = now;
            now = tmp;
            --y;
        }
        // 아래로
        while (x < top[0] - 1) {
            int tmp = room[x+1][y];
            room[x+1][y] = now;
            now = tmp;
            ++x;
        }
    }

    static void runAirFurifierBottom(int[][] room, int r, int c) {
        int x = bottom[0];
        int y = bottom[1] + 1;
        int now = room[x][y];
        room[x][y] = 0;
        // 오른쪽으로
        while (y < c - 1) {
            int tmp = room[x][y+1];
            room[x][y+1] = now;
            now = tmp;
            ++y;
        }
        // 아래로
        while (x < r - 1) {
            int tmp = room[x+1][y];
            room[x+1][y] = now;
            now = tmp;
            ++x;
        }
        // 왼쪽으로
        while (y > 0) {
            int tmp = room[x][y-1];
            room[x][y-1] = now;
            now = tmp;
            --y;
        }
        // 위로
        while (x > bottom[0] + 1) {
            int tmp = room[x-1][y];
            room[x-1][y] = now;
            now = tmp;
            --x;
        }
    }

    static void spreadDust(int[][] room, int r, int c) {
        // 미세먼지 퍼뜨리기
        /*
         * 1. 배열 선언하여 미세먼지 위치 저장
         * 2. 각 미세먼지에 대해 사방을 확인
         * 3. 범위 안이며 공기청정기가 아니면 확산안됨
         * 4. 확산되면 m / 5만큼 퍼지고 원래 위치는 m / 5만큼 빼기
         * 	   - 미세먼지는 한 번에 퍼지기 때문에 더해진/빼진 값만 저장할 2차원 배열 필요
         * 5. 현재 방 상태에 퍼진 후 변한 미세먼지 값 더함
         */
        List<int[]> dustList = new ArrayList<>();
        for (int row = 0; row < r; ++row) {
            for (int col = 0; col < c; ++col) {
                if (room[row][col] > 0) {
                    dustList.add(new int[] {row, col});
                }
            }
        }
        int[][] dustDiff = new int[r][c];

        for (int[] dust : dustList) {
            int x = dust[0];
            int y = dust[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (room[nx][ny] == -1) {
                    continue;
                }
                int spreadDust = room[x][y] / 5;
                dustDiff[nx][ny] += spreadDust;
                dustDiff[x][y] -= spreadDust;
            }
        }

        // 퍼진 미세먼지 한 번에 계산
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                // 미세먼지가 늘어났고 배열에 넣는 위치}
                room[row][col] += dustDiff[row][col];
            }
        }
    }
}