public class UserSolution {
    
    final static int ROOT = 1;
    final static int MAX = 100_000 * 20 + 5;
    static int id;
    static int[] count = new int[MAX];
    static int[][] next = new int[MAX][26];
	
	public void init() {
        int id = 2;
        for (int i = 0; i < MAX; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = 0;
            }
        }
	}
	
	public void insert(int buffer_size, String buf) {
        int curr = ROOT;
        for (int i = 0; i < buffer_size; i++) {
            char ch = buf.charAt(i);
            int idx = ch - 'a';
            // 현재 트라이에 없음
            if (next[curr][idx] == 0) {
                next[curr][idx] = id++;
            }
            curr = next[curr][idx];
            // 자신의 부분 문자열마다 count 1 증가
            ++count[curr];
        }
	}
	
	public int query(int buffer_size, String buf) {
        int curr = ROOT;
        for (int i = 0; i < buffer_size; i++) {
            char ch = buf.charAt(i);
            int idx = ch - 'a';
            curr = next[curr][idx];
        }
        // 자신을 부분 문자열로 가지는 문자열의 개수 리턴
        return count[curr];
	}
}
