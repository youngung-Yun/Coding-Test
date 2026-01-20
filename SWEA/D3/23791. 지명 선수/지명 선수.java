import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            char[] players = new char[n+1];
            int[] preferA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] preferB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int idxA = 0;
            int idxB = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    // A팀이 선택
                    while (players[preferA[idxA]] != '\u0000') {
                        ++idxA;
                    }
                    players[preferA[idxA]] = 'A';
                } else {
                    // B팀이 선택
                    while (players[preferB[idxB]] != '\u0000') {
                        ++idxB;
                    }
                    players[preferB[idxB]] = 'B';
                }
            }
            for (int i = 1; i <= n; i++) {
                sb.append(players[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}