import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            // index = (n-1) / 2;
            int[] rooms = new int[200];
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int min = Integer.min(a, b);
                int max = Integer.max(a, b);
                for (int room = (min - 1) / 2; room <= (max - 1) / 2; room++) {
                    rooms[room] += 1;
                }
            }
            int answer = Arrays.stream(rooms).max().getAsInt();
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}