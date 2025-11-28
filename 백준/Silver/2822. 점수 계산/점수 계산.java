import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] grades = new int[8];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 8; i++) {
            int grade = Integer.parseInt(br.readLine());
            grades[i - 1] = grade;
            map.put(grade, i);
        }

        Arrays.sort(grades);

        int sum = 0;
        int[] result = new int[5];
        for (int i = 3; i < 8; i++) {
            sum += grades[i];
            result[i - 3] = map.get(grades[i]);
        }

        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append('\n');
        Arrays.stream(result).forEach(e -> sb.append(e).append(' '));

        System.out.println(sb.toString());

        br.close();
    }
}