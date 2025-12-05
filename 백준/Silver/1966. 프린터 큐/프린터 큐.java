import java.io.*;
import java.util.*;

public class Main {
    
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         * [번호, 우선순위] 형태로 큐에 삽입
         * 우선순위 배열을 정렬
         * 현재 우선순위를 가리키는 인덱스 i
         * 우선순위[i] == 원소의 우선순위일 때 까지 poll 하고 다시 삽입
         * ++count
         * ++i
         * pop() == m이면 count 리턴
         * 
         */

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] priorities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Deque<int[]> queue = new ArrayDeque<>();
            for (int k = 0; k < n; k++) {
                queue.addLast(new int[] {k, priorities[k]});
            }

            Arrays.sort(priorities);

            int index = n - 1;
            int answer = 0;
            while (index < n) {


                int[] element = queue.removeFirst();
                if (element[1] == priorities[index]) {
                    ++answer;
                    --index;

                    if (element[0] == m) {
                        break;
                    }
                }
                else {
                    queue.addLast(element);
                }
            }
            sb.append(answer).append('\n');            
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
