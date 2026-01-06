import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    if (sb.length() > 0) {
                        list.add(trimZero(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            if (sb.length() > 0) {
                list.add(trimZero(sb.toString()));
            }
        }
        StringBuilder sb = new StringBuilder();
        list.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        for (String number : list) {
            sb.append(number).append('\n');
        }
        System.out.println(sb);
    }

    private static String trimZero(String str) {
        int index = 0;
        while (index < str.length() - 1 && str.charAt(index) == '0') {
            ++index;
        }
        return str.substring(index);
    }
}