import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] opinions = new int[9][2];
        for (int i = 0; i < 9; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            opinions[i] = new int[] {a, b};
        }

        int total = 0b1_111_111_110;
        for (int liar = 0; liar < 9; liar++) {
            // 특정 가능한 경우가 최소 한 가지는 있어야 하며 모두가 한 명을 가리켜야 함
            total &= think(opinions, liar);
        }
        if (Integer.bitCount(total) != 1) {
            System.out.println(-1);
        } else {
            int number = 1;
            while (total > (0b1 << number)) {
                ++number;
            }
            System.out.println(number);
        }
    }

    static int think(int[][] opinions, int liar) {
        int total = 0b1_111_111_110;

        for (int i = 0; i < 9; i++) {
            int[] opinion = opinions[i];
            int a = opinion[0];
            int b = opinion[1];
            if (i == liar) {
                if (a == 0) {
                    // A는 1루수가 아니다가 거짓 = A는 1루수다.
                    total &= (0b1 << b);
                } else {
                    // A는 1루수다가 거짓 = A는 1루수가 아니다.
                    total &= (~(0b1 << b));
                }
            } else {
                // A는 1루수가 아니다.
                if (a == 0) {
                    total &= (~(0b1 << b));
                // A는 1루수다.
                } else {
                    total &= (0b1 << b);
                }
            }
        }
        // 모순인 경우 모두가 가능성이 있는걸로 처리
        if (total == 0b0) {
            return 0b1_111_111_110;
        }
        return total;
    }
}