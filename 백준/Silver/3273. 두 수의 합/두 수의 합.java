import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int number : set) {
            if (set.contains(x - number)) {
                ++count;
            }
        }

        System.out.println(count / 2);
    }
}