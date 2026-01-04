import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        // 길이 순 정렬
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        Set<String> set = new HashSet<>();
        int result = 0;
        for (String word: words) {
            // 자신의 접두사들 set에 넣음
            for (int i = 1; i < word.length(); i++) {
                set.add(word.substring(0, i));
            }
            // 자신이 다른 단어의 접두사가 아닐 경우
            if (!set.contains(word)) {
                set.add(word);
                ++result;
            }
        }
        System.out.println(result);
    }
}
