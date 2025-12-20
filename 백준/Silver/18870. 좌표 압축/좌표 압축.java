import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        /*
        압축 결과 = 나보다 작은 수의 개수
         */
        int n = Integer.parseInt(br.readLine());
        List<Integer> original = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(toList());
        List<Integer> clone = new ArrayList<>(original);

        // 정렬
        Collections.sort(clone);

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (Integer number : clone) {
            if (!map.containsKey(number)) {
                map.put(number, count);
                count++;
            }
        }

        for (int number : original) {
            sb.append(map.get(number)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}