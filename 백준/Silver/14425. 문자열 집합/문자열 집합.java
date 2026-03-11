import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final int ROOT = 1;
        int unused = 2;
        final int MAX = 10_000 * 500 + 100;
        boolean[] isLast = new boolean[MAX];
        // next[i][n] = i번째인 문자 다음으로 오는 문자 n의 인덱스
        int[][] next = new int[MAX][26];

        for (int[] array : next) {
            Arrays.fill(array, -1);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            // Insert
            int curr = ROOT;
            for (char ch : str.toCharArray()) {
                if (next[curr][convert(ch)] == -1) {
                    // 없는 문자면 번호 부여
                    next[curr][convert(ch)] = unused++;
                }
                curr = next[curr][convert(ch)];
            }
            isLast[curr] = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();


            // Find
            int curr = ROOT;
            for (char ch : str.toCharArray()) {
                // 단어 없음
                if (next[curr][convert(ch)] == -1) {
                    curr = ROOT;
                    break;
                }
                curr = next[curr][convert(ch)];
            }

            if (isLast[curr]) {
                ++count;
            }
        }

        System.out.println(count);
    }

    private static int convert(char ch) {
        return ch - 'a';
    }
}
