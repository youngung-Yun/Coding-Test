import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int ROOT = 1;
    final static int NONE = -1;
    final static int MAX = 100_000 * 10 + 10;

    static int idx = 2;
    static int[] count = new int[MAX];
    static int[][] next = new int[MAX][26];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int[] count : next) {
            Arrays.fill(count, NONE);
        }

        int n = Integer.parseInt(bf.readLine());

        /*
         * 1. 트라이에 닉네임 삽입
         * 2. 삽입하면서, 아직 트라이에 없는 가장 짧은 접두사를 별칭으로 사용
         * 3. 가장 짧은 접두사가 없으면 같은 닉네임 수로 별칭 정함
         */
        for (int line = 0; line < n; line++) {
            String nickname = bf.readLine();
            int current = ROOT;
            int prefixIdx = nickname.length();
            for (int i = 0; i < nickname.length(); i++) {
                char ch = nickname.charAt(i);
                // 현재 문자가 트라이에 없음
                if (next[current][ch-'a'] == NONE) {
                    next[current][ch-'a'] = idx++;
                    prefixIdx = Integer.min(prefixIdx, i);
                }
                current = next[current][ch-'a'];
            }
            ++count[current];

            if (prefixIdx < nickname.length()) {
                System.out.println(nickname.substring(0, prefixIdx+ 1));
            } else if (count[current] == 1) {
                System.out.println(nickname);
            } else {
                System.out.println(nickname + count[current]);
            }
        }
    }
}
