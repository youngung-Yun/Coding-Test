import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
    	Map<String, Integer> colorMap = new HashMap<>();
        colorMap.put("red", 0);
        colorMap.put("orange", 1);
        colorMap.put("yellow", 2);
        colorMap.put("green", 3);
        colorMap.put("blue", 4);
        colorMap.put("purple", 5);

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            int colorA = colorMap.get(sc.next());
            int colorB = colorMap.get(sc.next());
            if (colorA == colorB) {
            	System.out.println('E');
            } else if ((colorA + 3) % 6 == colorB) {
            	System.out.println('C');
            }  else if ((colorA + 1) % 6 == colorB || (colorA + 5) % 6 == colorB) {
                System.out.println('A');
            } else {
                System.out.println('X');
            }
		}
	}
}