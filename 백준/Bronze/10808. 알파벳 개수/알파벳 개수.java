import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static Set<String> set = new HashSet<>();
    private final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] counts = new int[26];
        for (char ch : word.toCharArray()) {
            ++counts[ch  - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count).append(' ');
        }
        System.out.println(sb.toString());
    }
}
