import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static boolean[][] finished;
    static char[][] map;
    static Map<Character, int[]> dirMapper = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        initMapper();

        map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = row.charAt(c);
            }
        }

        visited = new boolean[n][m];
        finished = new boolean[n][m];
        
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                ans += findCycle(r, c);
            }
        }
        System.out.println(ans);
    }

    static int findCycle(int r, int c) {
        /*
         * 1. 계속 이동
         * 2. visited이면서 finished : 이미 찾은 사이클임. 0 리턴
         * 3. visited지만 finished가 아님 : 사이클 발견. finished 체크 후 1 리턴
         */
        boolean hasCycle = false;
        int nr = r + dirMapper.get(map[r][c])[0];
        int nc = c + dirMapper.get(map[r][c])[1];
        while (!visited[nr][nc]) {
            visited[nr][nc] = true;
            nr += dirMapper.get(map[nr][nc])[0];
            nc += dirMapper.get(map[nr][nc])[1];
        }

        if (!finished[nr][nc]) {
            hasCycle = true;
        }

        finished[r][c] = true;
        nr = r + dirMapper.get(map[r][c])[0];
        nc = c + dirMapper.get(map[r][c])[1];
        while (!finished[nr][nc]) {
            finished[nr][nc] = true;
            nr += dirMapper.get(map[nr][nc])[0];
            nc += dirMapper.get(map[nr][nc])[1];
        }

        return hasCycle ? 1 : 0;
    }

    static void initMapper() {
        dirMapper.put('U', new int[] {-1, 0});
        dirMapper.put('D', new int[] {1, 0});
        dirMapper.put('L', new int[] {0, -1});
        dirMapper.put('R', new int[] {0, 1});
    }
}