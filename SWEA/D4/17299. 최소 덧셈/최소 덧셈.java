import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            String number = bf.readLine();
            int min = Integer.parseInt(number);
            for (int separator = 1; separator < number.length(); separator++) {
                min = Integer.min(min, Integer.parseInt(number.substring(0, separator)) + Integer.parseInt(number.substring(separator)));
            }

            sb.append('#').append(testcase).append(' ')
                    .append(min).append('\n');
        }
        System.out.println(sb);
    }
}