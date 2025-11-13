import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        String table = br.readLine();

        List<Integer> hamburgerIdx = new ArrayList<>();
        List<Integer> peopleIdx = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char ch = table.charAt(i);
            if (ch == 'H') {
                hamburgerIdx.add(i);
            } else {
                peopleIdx.add(i);
            }
        }

        int count = 0;
        int hi = 0;
        int pi = 0;

        while (hi < hamburgerIdx.size() && pi < peopleIdx.size()) {
            if (Math.abs(hamburgerIdx.get(hi) - peopleIdx.get(pi)) <= K) {
                ++count;
                ++hi;
                ++pi;
            } else if (hamburgerIdx.get(hi) < peopleIdx.get(pi)) {
                ++hi;
            } else {
                ++pi;
            }
        }

        System.out.println(count);
    }

}