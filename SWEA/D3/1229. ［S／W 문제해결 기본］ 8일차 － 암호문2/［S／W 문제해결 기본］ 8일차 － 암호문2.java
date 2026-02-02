import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(token.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            token = new StringTokenizer(br.readLine());
            while (token.hasMoreTokens()) {
                String command = token.nextToken();
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                if (command.equals("I")) {
                    // 역순으로 삽입해야 제대로 삽입됨
                    Deque<Integer> stack = new ArrayDeque<>();
                    for (int i = 0; i < y; i++) {
                        stack.push(Integer.parseInt(token.nextToken()));
                    }
                    while (!stack.isEmpty()) {
                        list.add(x, stack.pop());
                    }
                } else if (command.equals("D")) {
                    for (int i = 0; i < y; i++) {
                        list.remove(x);
                    }
                }
            }
            sb.append('#').append(testCase).append(' ');
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}