import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        long[] guitars = new long[n];
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            guitars[i] = stringToBinary(input[1]);
        }

        int maxCanPlayMusic = 0;
        int minGuitars = -1;

        for (long comb = 0; comb < (0b1L << n); ++comb) {
            long music = 0b0L;
            for (int i = 0; i < n; i++) {
                if ((comb & (0b1 << i)) != 0) {
                    music |= guitars[i];
                }
            }
            int canPlayMusic = Long.bitCount(music);
            int guitarCount = Long.bitCount(comb);
            if (maxCanPlayMusic < canPlayMusic) {
                maxCanPlayMusic = canPlayMusic;
                minGuitars = guitarCount;
            } else if (maxCanPlayMusic == canPlayMusic) {
                minGuitars = Integer.min(minGuitars, guitarCount);
            }
        }

        System.out.println(minGuitars);
    }

    static long stringToBinary(String str) {
        long binary = 0b0L;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'Y') {
                binary |= (0b1L << i);
            }
        }
        return binary;
    }
}