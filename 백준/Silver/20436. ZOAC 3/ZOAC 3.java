import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, int[]> leftHand = new HashMap<>();
        leftHand.put('q', new int[] {0, 0});
        leftHand.put('a', new int[] {0, 1});
        leftHand.put('z', new int[] {0, 2});
        leftHand.put('w', new int[] {1, 0});
        leftHand.put('s', new int[] {1, 1});
        leftHand.put('x', new int[] {1, 2});
        leftHand.put('e', new int[] {2, 0});
        leftHand.put('d', new int[] {2, 1});
        leftHand.put('c', new int[] {2, 2});
        leftHand.put('r', new int[] {3, 0});
        leftHand.put('f', new int[] {3, 1});
        leftHand.put('v', new int[] {3, 2});
        leftHand.put('t', new int[] {4, 0});
        leftHand.put('g', new int[] {4, 1});
        Map<Character, int[]> rightHand = new HashMap<>();
        rightHand.put('b', new int[] {0, 2});
        rightHand.put('y', new int[] {1, 0});
        rightHand.put('h', new int[] {1, 1});
        rightHand.put('n', new int[] {1, 2});
        rightHand.put('u', new int[] {2, 0});
        rightHand.put('j', new int[] {2, 1});
        rightHand.put('m', new int[] {2, 2});
        rightHand.put('i', new int[] {3, 0});
        rightHand.put('k', new int[] {3, 1});
        rightHand.put('o', new int[] {4, 0});
        rightHand.put('l', new int[] {4, 1});
        rightHand.put('p', new int[] {5, 0});

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] leftPosition = leftHand.get(st.nextToken().charAt(0));
        int[] rightPosition = rightHand.get(st.nextToken().charAt(0));
        String word = br.readLine();

        int minTime = word.length();
        for (char ch : word.toCharArray()) {
            if (leftHand.containsKey(ch)) {
                int[] nextPosition = leftHand.get(ch);
                int distance = Math.abs(leftPosition[0] - nextPosition[0]) + Math.abs(leftPosition[1] - nextPosition[1]);
                minTime += distance;
                leftPosition = nextPosition;
            } else {
                int[] nextPosition = rightHand.get(ch);
                int distance = Math.abs(rightPosition[0] - nextPosition[0]) + Math.abs(rightPosition[1] - nextPosition[1]);
                minTime += distance;
                rightPosition = nextPosition;
            }
        }
        System.out.println(minTime);
    }
}