import java.util.*;

class Solution {
    
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    final static int WIDTH = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] waitingRoom = makeMatrix(place);
            boolean followRule = true;
            // 1. 사람 위치마다 거리 최대 2인 BFS 실행
            //    - 파티션이면 이동 불가능
            // 2. 거리 2 내에 다른 사람까지 도달 가능하면 거리두기 안됨
            outer:
            for (int r = 0; r < WIDTH; r++) {
                for (int c = 0; c < WIDTH; c++) {
                    if (waitingRoom[r][c] != 'P') {
                        continue;
                    }
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[] {r, c});
                    int[][] distance = makeDistanceMatrix();
                    distance[r][c] = 0;
                    while (!queue.isEmpty()) {
                        int[] current = queue.removeFirst();
                        int x = current[0];
                        int y = current[1];
                        // 거리두기 안됨
                        if (distance[x][y] > 0 && waitingRoom[x][y] == 'P') {
                            followRule = false;
                            break outer;
                        }
                        // 현재 거리 2 이상이면 다음 경로 볼 필요 없음
                        if (distance[x][y] >= 2) {
                            continue;
                        }
                        for (int[] delta : deltas) {
                            int nx = x + delta[0];
                            int ny = y + delta[1];
                            if (nx < 0 || ny < 0 || nx >= WIDTH || ny >= WIDTH) {
                                continue;
                            }
                            if (distance[nx][ny] != -1) {
                                continue;
                            }
                            if (waitingRoom[nx][ny] == 'X') {
                                continue;
                            }
                            distance[nx][ny] = distance[x][y] + 1;
                            queue.offerLast(new int[] {nx, ny});
                        } 
                    }
                }
            }
            answer[i] = followRule ? 1 : 0;
        }
        return answer;
    }
    
    static int[][] makeDistanceMatrix() {
        int[][] matrix = new int[WIDTH][WIDTH];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        return matrix;
    }
    
    static char[][] makeMatrix(String[] strings) {        
        char[][] matrix = new char[WIDTH][WIDTH];
        for (int r = 0; r < WIDTH; r++) {
            for (int c = 0; c < WIDTH; c++) {
                matrix[r][c] = strings[r].charAt(c);
            }
        }
        return matrix;
    }
}