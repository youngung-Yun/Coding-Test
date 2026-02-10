import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    final static int[] dx = {0, 0, 1, 0, -1};
    final static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());

            int totalTime = Integer.parseInt(stk.nextToken());
            int batteryChargerCount = Integer.parseInt(stk.nextToken());
            int[] moveA = new int[totalTime];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < totalTime; i++) {
                moveA[i] = Integer.parseInt(stk.nextToken());
            }
            int[] moveB = new int[totalTime];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < totalTime; i++) {
                moveB[i] = Integer.parseInt(stk.nextToken());
            }
            // [x, y, coverage, performance]
            int[][] batteryChargers = new int[batteryChargerCount][4];
            for (int i = 0; i < batteryChargerCount; i++) {
                stk = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int coverage = Integer.parseInt(stk.nextToken());
                int performance = Integer.parseInt(stk.nextToken());
                batteryChargers[i] = new int[] {x, y, coverage, performance};
            }

            int ax = 1;
            int ay = 1;
            int bx = 10;
            int by = 10;

            int charge = 0;
            /*
             * 2. 모든 BC에 대해 A나 B가 범위 안인지 확인
             * 4. 각 BC에 대해 범위 안인 사용자가 충전 가능한 양 비교하여 max값 구해 더함
             * 5. 사용자 이동
             * 5. totalTime번 반복
             */
            for (int i = 0; i <= totalTime; i++) {
                int[] perfA = new int[batteryChargerCount];
                int[] perfB = new int[batteryChargerCount];
                for (int k = 0; k < batteryChargerCount; k++) {
                    int[] batteryCharger = batteryChargers[k];
                    int x = batteryCharger[0];
                    int y = batteryCharger[1];
                    int coverage = batteryCharger[2];
                    int performance = batteryCharger[3];
                    // a와의 거리 계산
                    int distanceA = getDistance(x, y, ax, ay);
                    // b와의 거리 계산
                    int distanceB = getDistance(x, y, bx, by);

                    // A가 범위 안
                    if (distanceA <= coverage) {
                        perfA[k] = performance;
                    }
                    // B가 범위 안
                    if (distanceB <= coverage) {
                        perfB[k] = performance;
                    }
                }
                int sum = 0;
                for (int a = 0; a < batteryChargerCount; a++) {
                    for (int b = 0; b < batteryChargerCount; b++) {
                        // 같은 bc
                        if (a == b && perfA[a] != 0 && perfB[b] != 0) {
                            sum = Integer.max(sum, perfA[a]);
                        // 다른 bc
                        } else {
                            sum = Integer.max(sum, perfA[a] + perfB[b]);
                        }
                    }
                }
                charge += sum;

                // 마지막 이동 후 종료
                if (i == totalTime) {
                    break;
                }
                ax += dx[moveA[i]];
                ay += dy[moveA[i]];
                bx += dx[moveB[i]];
                by += dy[moveB[i]];
            }

            sb.append('#').append(testCase).append(' ')
                    .append(charge).append('\n');
        }
        System.out.println(sb);
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}