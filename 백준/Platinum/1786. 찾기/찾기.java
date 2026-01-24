import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String t = br.readLine();
        String p = br.readLine();

        int[] failure = makeFailture(p);

        int j = 0;
        int count = 0;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = failure[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                ++count;
                indices.add(i - p.length() + 2);
                j = failure[j - 1];
            }
        }

        sb.append(count).append('\n');
        for (int index : indices) {
            sb.append(index).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] makeFailture(String str) {
        int j = 0;
        int[] failure = new int[str.length()];

        // 실패 함수 만들기
        for (int i = 1; i < str.length(); i++) {
            // j > 0 : j가 0이면 일치하는 단어 없음
            // s.charAt(i) != s.charAt(J) : 마지막 단어가 일치 안함
            // j -> failure[j - 1]
            // 일치하지 않는 j를 제외하고 S[0: j-1]까지에서 제일 긴 겹치는 단어 길이 = F[j - 1]
            // 마지막이 안겹치면 다시 반복
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = failure[j - 1];
            }
            // s[i] == s[j]면 이전 실패 함수 값 + 1 = j
            if (str.charAt(i) == str.charAt(j)) {
                failure[i] = ++j;
            }
        }

        return failure;
    }
}

