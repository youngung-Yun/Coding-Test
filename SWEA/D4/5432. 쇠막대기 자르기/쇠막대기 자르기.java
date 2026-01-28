import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String stick = br.readLine();
            int total = 0;
            int current = 0;
            for (int i = 0; i < stick.length(); i++) {
                // 레이저면 현재 쇠막대기 만큼 새로운 쇠막대기가 생김
                if (stick.charAt(i) == '(' && stick.charAt(i+1) == ')') {
                    total += current;
                // 쇠막대기의 시작이면 현재 쇠막대기 및 총 쇠막대기 개수 1 추가
                } else if (stick.charAt(i) == '(') {
                    total += 1;
                    current += 1;
                // 쇠막대기의 끝이면 현재 쇠막대기 개수 1 감소
                } else if (stick.charAt(i) == ')' && stick.charAt(i-1) != '(') {
                    current -= 1;
                }
            }
            sb.append('#').append(testCase).append(' ').append(total).append('\n');
        }
        System.out.println(sb);
    }
}