import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
         * k >= 0, n >= 1
         * f(k, n) = f(k, n - 1) = f(k - 1, n)
         */

        int t = Integer.parseInt(br.readLine());

        int[][] apartment = new int[15][15]; // 테스트케이스마다 재활용

        for (int i = 0; i < t; ++i) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (apartment[k][n] != 0) { // 이전 테스트케이스에서 계산했으면 바로 구함
                bw.write(String.valueOf(apartment[k][n]));
                bw.newLine();
            }
            else {
                for (int floor = 0; floor <= k; ++floor) {
                    for (int ho = 1; ho <= n; ++ho) {
                        if (apartment[floor][ho] != 0) continue; // 이전에 이미 구했으면 continue;
                        if (floor == 0) {
                            apartment[floor][ho] = ho; // 0층은 호수만큼 산다.
                        }
                        else {
                            apartment[floor][ho] = apartment[floor][ho - 1] + apartment[floor - 1][ho];
                        }
                    }
                }
                bw.write(String.valueOf(apartment[k][n]));
                bw.newLine();
            }
        }
        bw.flush();
    }

}   