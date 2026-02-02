import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer token = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(token.nextToken());
        int p = Integer.parseInt(token.nextToken());
        String dna = reader.readLine();

        // A, C, G, T
        int[] constraints = new int[4];
        token = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++) {
            constraints[i] = Integer.parseInt(token.nextToken());
        }

        int[] currentCount = new int[4];
        // 슬라이딩 윈도우 초기화
        for (int i = 0; i < p; i++) {
            char ch = dna.charAt(i);
            ++currentCount[getIndex(ch)];
        }

        int ans = 0;
        if (followConstraint(constraints, currentCount)) {
            ++ans;
        }

        int left = 0;
        for (int i = p; i < s; i++) {
            ++currentCount[getIndex(dna.charAt(i))];
            --currentCount[getIndex(dna.charAt(left))];
            if (followConstraint(constraints, currentCount)) {
                ++ans;
            }
            ++left;
        }
        System.out.println(ans);
    }

    static int getIndex(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    static boolean followConstraint(int[] constraint, int[] current) {
        for (int i = 0; i < 4; i++) {
            if (constraint[i] > current[i]) {
                return false;
            }
        }
        return true;
    }
}
