import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long[] knownSongs = new long[n+1];

        int newSong = 0;
        int e = Integer.parseInt(bf.readLine());
        for (int campfire = 0; campfire < e; campfire++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(stk.nextToken());
            int[] candidates = new int[k];
            boolean participateSunyoung = false;
            for (int i = 0; i < k; i++) {
                int number = Integer.parseInt(stk.nextToken());
                candidates[i] = number;
                if (number == 1) {
                    participateSunyoung = true;
                }
            }

            if (participateSunyoung) {
                for (int c : candidates) {
                    knownSongs[c] |= (0b1L << newSong);
                }
                ++newSong;
            } else {
                long everySongs = 0L;
                for (int c : candidates) {
                    everySongs |= knownSongs[c];
                }
                for (int c : candidates) {
                    knownSongs[c] = everySongs;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (knownSongs[i] == (0b1L << newSong) - 1L) {
                System.out.println(i);
            }
        }
    }
}