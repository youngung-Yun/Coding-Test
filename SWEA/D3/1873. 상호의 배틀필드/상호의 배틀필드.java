import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    // 상 하 좌 우
    final static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    static int h;
    static int w;
    static char[][] battlefield;
    static int currentDir = 0;
    static int x;
    static int y;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            h = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());
            battlefield = new char[h][w];
            for (int r = 0; r < h; r++) {
                String row = bf.readLine();
                for (int c = 0; c < w; c++) {
                    char object = row.charAt(c);
                    battlefield[r][c] = object;
                    if (object == '<' || object == '>' || object == '^' || object == 'v') {
                        x = r;
                        y = c;
                        if (object == '^') {
                            currentDir = 0;
                        } else if (object == 'v') {
                            currentDir = 1;
                        } else if (object == '<') {
                            currentDir = 2;
                        } else if (object == '>') {
                            currentDir = 3;
                        }
                    }
                }
            }

            int n = Integer.parseInt(bf.readLine());
            String actions = bf.readLine();
            for (char action : actions.toCharArray()) {
                if (action == 'U') {
                    rotateAndMove(0);
                } else if (action == 'D') {
                    rotateAndMove(1);
                } else if (action == 'L') {
                    rotateAndMove(2);
                } else if (action == 'R') {
                    rotateAndMove(3);
                } else {
                    shoot();
                }
            }

            sb.append('#').append(testCase).append(' ');
            for (char[] row : battlefield) {
                for (char col : row) {
                    sb.append(col);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    static void rotateAndMove(int dir) {
        currentDir = dir;
        rotate();
        move();
    }

    static void rotate() {
        if (currentDir == 0) {
            battlefield[x][y] = '^';
        } else if (currentDir == 1) {
            battlefield[x][y] = 'v';
        } else if (currentDir == 2) {
            battlefield[x][y] = '<';
        } else if (currentDir == 3) {
            battlefield[x][y] = '>';
        }
    }

    static void move() {
        int nx = x + dirs[currentDir][0];
        int ny = y + dirs[currentDir][1];
        if (!isValid(nx, ny) || battlefield[nx][ny] != '.') {
            return;
        }
        char tank = battlefield[x][y];
        battlefield[x][y] = '.';
        battlefield[nx][ny] = tank;
        x = nx;
        y = ny;
    }

    static void shoot() {
        int nx = x + dirs[currentDir][0];
        int ny = y + dirs[currentDir][1];
        while (isValid(nx, ny)) {
            // 벽돌 부숨
            if (battlefield[nx][ny] == '*') {
                battlefield[nx][ny] = '.';
                break;
            // 강철 못부숨
            } else if (battlefield[nx][ny] == '#') {
                break;
            }
            nx += dirs[currentDir][0];
            ny += dirs[currentDir][1];
        }
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
}