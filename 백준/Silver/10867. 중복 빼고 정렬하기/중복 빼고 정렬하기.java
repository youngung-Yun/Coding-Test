import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isExist = new boolean[2_001];
        List<Integer> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for (String str : input) {
            int number = Integer.parseInt(str);
            if (!isExist[number + 1_000]) {
                isExist[number + 1_000] = true;
                list.add(number);
            }
        }

        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e).append(' '));

        System.out.println(sb.toString());

        br.close();
    }
} 