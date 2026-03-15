import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String t = bf.readLine();

        StringBuilder sb = new StringBuilder(t);
        while (s.length() < sb.length()) {
            char last = sb.charAt(sb.length() - 1);
            if (last == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb = sb.reverse();
            }
        }

        System.out.println(s.equals(sb.toString()) ? 1 : 0);
    }
}