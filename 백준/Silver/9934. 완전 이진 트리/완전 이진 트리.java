import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= k; i++) {
            list.add(new ArrayList<>());
        }

        int[] inorder = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursion(inorder, 0, inorder.length - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int depth = 1; depth <= k; depth++) {
            for (int node : list.get(depth)) {
                sb.append(node).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void recursion(int[] inorder, int left, int right, int depth) {
        if (depth > k) {
            return;
        }

        int center = (left + right) / 2;
        recursion(inorder, left, center - 1, depth + 1);
        recursion(inorder, center + 1, right, depth + 1);
        list.get(depth).add(inorder[center]);
    }
}