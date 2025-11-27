import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        A:for (int i = 0; i < N; ++i) {
            boolean[] isExist = new boolean[26];
            String word = br.readLine();

            char prev = word.charAt(0);
            for (int k = 0; k < word.length(); ++k) {
                char curr = word.charAt(k);
                if (prev != curr && isExist[curr - 'a']) {
                    continue A;
                }
                prev = curr;
                isExist[curr - 'a'] = true;
            }
            ++count;
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}