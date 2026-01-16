
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Node> nodeMap = new HashMap<>();

        Node ROOT = new Node('A', null, null);
        nodeMap.put('A', ROOT);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parent = nodeMap.get(ch);
            if (left != '.') {
                Node leftChild = new Node(left, null, null);
                parent.left = leftChild;
                nodeMap.put(left, leftChild);
            }
            if (right != '.') {
                Node rightChild = new Node(right, null, null);
                parent.right = rightChild;
                nodeMap.put(right, rightChild);
            }
        }

        prefix(ROOT);
        sb.append('\n');
        infix(ROOT);
        sb.append('\n');
        postfix(ROOT);
        System.out.println(sb);
    }

    static void prefix(Node root) {
        if (root == null) {
            return;
        }
        sb.append(root.name);
        prefix(root.left);
        prefix(root.right);
    }

    static void infix(Node root) {
        if (root == null) {
            return;
        }
        infix(root.left);
        sb.append(root.name);
        infix(root.right);
    }

    static void postfix(Node root) {
        if (root == null) {
            return;
        }
        postfix(root.left);
        postfix(root.right);
        sb.append(root.name);
    }

    static class Node {
        public char name;
        public Node left;
        public Node right;

        public Node(char name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }
}