
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // 공기 청정기의 윗부분 위치
    static int[] airPurifier;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());


        int[][] room = new int[r][c];
        for (int row = 0; row < r; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < c; col++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1 && room[row-1][col] == -1) {
                    airPurifier = new int[] {row-1, col};
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
        int x = airPurifier[0];
        int y = airPurifier[1] + 1;
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
        while (x < airPurifier[0] - 1) {
            int tmp = room[x+1][y];
            room[x+1][y] = now;
            now = tmp;
            ++x;
        }
    }

    static void runAirFurifierBottom(int[][] room, int r, int c) {
        int x = airPurifier[0] + 1;
        int y = airPurifier[1] + 1;
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
        while (x > airPurifier[0] + 1 + 1) {
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
        int[][] dustDiff = new int[r][c];

        for (int row = 0; row < r; ++row) {
            for (int col = 0; col < c; ++col) {
                if (room[row][col] <= 0) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int nx = row + dir[0];
                    int ny = col + dir[1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }
                    if (room[nx][ny] == -1) {
                        continue;
                    }
                    int spreadDust = room[row][col] / 5;
                    dustDiff[nx][ny] += spreadDust;
                    dustDiff[row][col] -= spreadDust;
                }
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