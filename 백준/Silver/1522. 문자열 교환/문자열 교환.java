import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. a의 개수 구함 = a의 개수가 윈도우 크기
        // 2. 윈도우가 문자열을 한 바퀴 돌며, 그 중 가장 b의 개수가 적은 만큼 교환하는 것이 최솟값
        String str = br.readLine();
        int size = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a') {
                ++size;
            }
        }
        int needSwapCount = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                // init
                for (int j = 0; j < size; j++) {
                    if (str.charAt(j) == 'b') {
                        ++needSwapCount;
                    }
                }
                result = needSwapCount;
                continue;
            }
            if (str.charAt(i-1) == 'b') {
                --needSwapCount;
            }
            int right = (i + size - 1) % str.length();
            if (str.charAt(right) == 'b') {
                ++needSwapCount;
            }
            result = Integer.min(result, needSwapCount);
        }
        System.out.println(result);
    }
}