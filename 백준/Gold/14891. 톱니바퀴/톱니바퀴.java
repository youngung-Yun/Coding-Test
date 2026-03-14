import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] magnets;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        magnets = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String input = bf.readLine();
            int[] magnet = new int[8];
            for (int j = 0; j < 8; j++) {
                // N극 = 0, S극 = 1
                magnet[j] = input.charAt(j) - '0';
            }
            magnets[i] = magnet;
        }

        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int idx = Integer.parseInt(token.nextToken()) - 1;
            // 1 = 시계방향, -1 = 반시계방향
            int dir = Integer.parseInt(token.nextToken());

            rotate(idx, dir);
        }
        int ans = computeGrade();

        System.out.println(ans);
    }

    static void rotate(int number, int dir) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {number, dir});
        // 왼쪽 자석 확인
        checkLeftMagnet(number - 1, -dir, list);
        // 오른쪽 자석 확인
        checkRightMagnet(number + 1, -dir, list);

        for (int[] magnet : list) {
            int idx = magnet[0];
            if (magnet[1] == 1) {
                magnets[idx] = rotateClockwise(idx);
            } else {
                magnets[idx] = rotateCounterClockwise(idx);
            }
        }
    }

    static void checkLeftMagnet(int idx, int dir, List<int[]> list) {
        if (idx < 0) {
            return;
        }
        if (magnets[idx][2] != magnets[idx+1][6]) {
            list.add(new int[] {idx, dir});
            checkLeftMagnet(idx - 1, -dir, list);
        }
    }
    static void checkRightMagnet(int idx, int dir, List<int[]> list) {
        if (idx >= 4) {
            return;
        }
        if (magnets[idx][6] != magnets[idx-1][2]) {
            list.add(new int[] {idx, dir});
            checkRightMagnet(idx + 1, -dir, list);
        }
    }

    static int[] rotateClockwise(int idx) {
        int[] rotated = Arrays.copyOf(magnets[idx], 8);
        // +1한 위치로 이동
        int tmp = rotated[7];
        for (int i = 7; i >= 1; i--) {
            rotated[i] = rotated[i-1];
        }
        rotated[0] = tmp;
        return rotated;
    }

    static int[] rotateCounterClockwise(int idx) {
        int[] rotated = Arrays.copyOf(magnets[idx], 8);
        // -1한 위치로 이동
        int tmp = rotated[0];
        for (int i = 0; i < 7; i++) {
            rotated[i] = rotated[i+1];
        }
        rotated[7] = tmp;
        return rotated;
    }

    static int computeGrade() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += magnets[i][0] * (0b1 << i);
        }
        return sum;
    }
}