import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String baseWord = bf.readLine();
        int[] baseCount = getCount(baseWord);

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            String word = bf.readLine();
            int[] count = getCount(word);
            ans += isSimilar(baseCount, count) ? 1 : 0;
        }
        System.out.println(ans);
    }

    static int[] getCount(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            ++count[ch - 'A'];
        }
        return count;
    }

    static boolean isSimilar(int[] base, int[] other) {
        // 개수 차이가 없거나, 1개 차이가 1개거나, 한 배열은 1개 많고 한 배열은 1개 적거나
        int baseDiff = 0;
        int otherDiff = 0;
        for (int i = 0; i < 26; i++) {
            if (Math.abs(base[i] - other[i]) > 1) {
                return false;
            } else if (base[i] == other[i] + 1) {
                ++baseDiff;
            } else if (base[i] + 1 == other[i]) {
                ++otherDiff;
            }
        }
        return ((baseDiff == 0 || baseDiff == 1) &&
                (otherDiff == 0 || otherDiff == 1));
    }
}