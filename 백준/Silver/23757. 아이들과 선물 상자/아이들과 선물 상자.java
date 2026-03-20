import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Integer> present = new PriorityQueue<>(Comparator.reverseOrder());
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            present.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(bf.readLine());
        int[] need = new int[m];
        for (int i = 0; i < m; i++) {
            need[i] = Integer.parseInt(stk.nextToken());
        }

        boolean givePresentAll = true;
        for (int count : need) {
            if (present.peek() < count) {
                givePresentAll = false;
                break;
            }
            present.add(present.poll() - count);
        }

        System.out.println(givePresentAll ? 1 : 0);
    }
}