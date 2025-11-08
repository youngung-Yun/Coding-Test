import java.io.*;
import java.util.*;

public class Main {
    
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         *  현재 수열의 숫자 number
         *  다음 숫자 next가 number보다 작아질 때까지 스택에 넣음
         *  스택의 top이 number면 peek
         *  아니면 못만듬듬
         */

        int n = Integer.parseInt(br.readLine());
        boolean canMake = true;
        int next = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            
            if (!canMake) continue;

            while (next <= number) {
                stack.push(next++);
                sb.append('+').append('\n');
            }
            if (stack.peek() == number) {
                stack.pop();
                sb.append('-').append('\n');
            }
            else {
                sb.setLength(0);
                sb.append("NO");
                canMake = false;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}
