import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        String pattern = br.readLine();
        int[] lps = computeLpsArray(pattern);
        int count = 0;
        List<Integer> pos = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < string.length(); i++) {
            // 현재 문자가 일치하는 실패 함수 찾을때까지 이동
            while (length > 0 && string.charAt(i) != pattern.charAt(length)) {
                length = lps[length - 1];
            }
            // 찾아서 일치하면 length 1 증가 (일치하지 않으면 length는 0임)
            if (string.charAt(i) == pattern.charAt(length)) {
                length += 1;
            }
            // 패턴이 모두 일치
            if (length == pattern.length()) {
                count += 1;
                pos.add(i - length + 1);
                length = lps[length - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int index : pos) {
            // 들어가 있는건 0-based인 인덱스이기 때문에 1을 더해서 1-based로 만듦
            sb.append(index + 1).append('\n');
        }
        System.out.println(sb);
    }

    static int[] computeLpsArray(String pattern) {
        int m = pattern.length();
        // lps[i] = 앞의 (i+1)글자에서 접두사와 접미사가 일치하는 최대 길이
        int[] lps = new int[m];
        // 현재 일치하는 부분의 길이
        int length = 0;
        for (int i = 1; i < m; i++) {
            while (length > 0 && pattern.charAt(i) != pattern.charAt(length)) {
                length = lps[length - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length += 1;
                lps[i] = length;
            }
        }
        return lps;
    }

}