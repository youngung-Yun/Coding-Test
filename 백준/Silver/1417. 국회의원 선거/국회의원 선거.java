import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int myVotes = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> othersVotes = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            othersVotes.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (!othersVotes.isEmpty() && myVotes <= othersVotes.peek()) {
            othersVotes.add(othersVotes.poll() - 1);
            ++myVotes;
            ++count;
        }
        System.out.println(count);
    }
}

