import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] inorder;
    static int[] postorder;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        inorder = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursion(0, n, 0, n);
        System.out.println(sb);
    }

    static void recursion(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft >= inorderRight || postorderLeft >= postorderRight) {
            return;
        }

        int root = postorder[postorderRight-1];
        sb.append(root).append(' ');
        int inorderIdx = indexOf(inorderLeft, inorderRight, root);

        int inorderCount = inorderIdx - inorderLeft;
        recursion(inorderLeft, inorderIdx, postorderLeft, postorderLeft + inorderCount);
        recursion(inorderIdx + 1, inorderRight, postorderLeft + inorderCount, postorderRight - 1);
    }

    static int indexOf(int left, int right, int value) {
        int idx = -1;
        for (int i = left; i < right; i++) {
            if (inorder[i] == value) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}