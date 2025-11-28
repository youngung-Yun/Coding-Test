import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        int[][] medals = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int number = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);

            medals[number] = new int[] {gold, silver, bronze};
        }

        int[] grades = new int[n + 1];
        Arrays.fill(grades, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                // 금 비교
                if (medals[i][0] > medals[j][0]) {
                    continue;
                } else if (medals[i][0] < medals[j][0]) {
                    ++grades[i];
                    continue;
                } else {
                    // 은 비교
                    if (medals[i][1] > medals[j][1]) {
                        continue;
                    } else if (medals[i][1] < medals[j][1]) {
                        ++grades[i];
                        continue;
                    } else {
                        // 동 비교
                        if (medals[i][2] >= medals[j][2]) {
                            continue;
                        } else if (medals[i][2] < medals[j][2]) {
                            ++grades[i];
                            continue;
                        }
                    }
                }
            }
        }
        System.out.println(grades[k]);
        br.close();
    }
}