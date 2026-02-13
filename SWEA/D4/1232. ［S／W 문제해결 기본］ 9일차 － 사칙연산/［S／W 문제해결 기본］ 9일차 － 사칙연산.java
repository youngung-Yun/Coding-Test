import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    final static int NONE = -1;
    static Map<Integer, Node> tree;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; testcase <= 10; ++testcase) {
            n = Integer.parseInt(bf.readLine());
            tree = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                int number = Integer.parseInt(stk.nextToken());
                String value = stk.nextToken();
                Node node = new Node(value);
                if (stk.hasMoreTokens()) {
                    int left = Integer.parseInt(stk.nextToken());
                    node.leftChild = left;
                }
                if (stk.hasMoreTokens()) {
                    int right = Integer.parseInt(stk.nextToken());
                    node.rightChild = right;
                }
                tree.put(number, node);
            }

            int result = operate(1);
            sb.append('#').append(testcase).append(' ')
                    .append(result).append('\n');
        }
        System.out.println(sb);
    }
    static int operate(int now) {
        Node node = tree.get(now);
        if (node.leftChild == -1) {
            return Integer.parseInt(node.value);
        }

        char operator = node.value.charAt(0);
        int num1 = operate(node.leftChild);
        int num2 = operate(node.rightChild);

        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    static class Node {
        public String value;
        public int leftChild;
        public int rightChild;

        public Node(String value) {
            this.value = value;
            leftChild = NONE;
            rightChild = NONE;
        }
    }
}