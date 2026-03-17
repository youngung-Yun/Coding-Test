import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> preorder = new ArrayList<>();
        while (true) {

            String input = bf.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            preorder.add(Integer.parseInt(input));
        }

        findPostorder(preorder, preorder.size(), 0, preorder.size());

        System.out.println(sb);
    }

    private static void findPostorder(List<Integer> preorder, int n, int start, int end) {
        /*
         * start가 현재 서브트리의 루트
         * end 전까지 내려가며 나보다 큰 수가 처음 나오는 인덱스 찾음
         * start부터 그 인덱스 전까지가 나의 왼쪽 서브트리, 인덱스부터 end 전까지의 나의 오른쪽 서브트리
         */

        int idx = start + 1;
        while (idx < end && preorder.get(start) > preorder.get(idx)) {
            ++idx;
        }

        if (start + 1 < idx) {
            findPostorder(preorder, n, start + 1, idx);
        }
        if (idx < end) {
            findPostorder(preorder, n, idx, end);
        }
        sb.append(preorder.get(start)).append('\n');
    }
}