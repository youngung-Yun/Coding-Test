import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 0; testCase < t; ++testCase) {
            int n = sc.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = sc.nextInt();
            }

            StringBuilder sb = new StringBuilder();
            List<Integer> center = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {

                list.add(sequence[i]);

                if (i % 2 == 0) {
                    list.sort(Comparator.naturalOrder());
                    center.add(list.get(i / 2));
                    ++count;
                }
            }
            sb.append(count).append('\n');
            for (int i = 0; i < center.size(); i++) {
                sb.append(center.get(i)).append(' ');
                if ((i + 1) % 10 == 0 && (i + 1) != center.size()) {
                    sb.append('\n');
                }
            }
            System.out.println(sb);
        }
    }
}