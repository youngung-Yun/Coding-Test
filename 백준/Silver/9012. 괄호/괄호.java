import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            String str = br.readLine();
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                }
                else {
                    // ')'인데 스택 비었다 = 짝 안맞음
                    // 반복문 밖에 isEmpty()와 맞추기 위해 아무거나 하나 삽입 후 break
                    if (stack.isEmpty()) {
                        stack.push('x');
                        break;
                    }
                    stack.pop();
                }
            // 비어있지 않다 = 짝이 없는 '('가 있음
            }
            if (!stack.isEmpty()) {
                bw.write("NO");
                bw.newLine();
            }
            else {
                bw.write("YES");
                bw.newLine();
            }
        }
        bw.flush();
    }

}   