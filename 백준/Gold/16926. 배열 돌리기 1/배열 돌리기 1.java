import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		String[][] l = new String[N][M];
		
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				l[r][c] = st.nextToken();
			}
		}
		
		for(int r = 0; r < R; r++) {
			int tempr = N;
			int tempc = M;
			String[][] newl = new String[N][M]; 
			int[] start = {0, 0};
			int[] end = {N - 1, M - 1};
			
			while(true) {
				for(int i = 0; i < tempc - 1; i++) {
					newl[start[0]][start[1] + i] = l[start[0]][start[1] + i + 1]; 
				}
				for(int i = 0; i < tempr - 1; i++) {
					newl[start[0] + i][end[1]] = l[start[0] + i + 1][end[1]];
				}
				for(int i = 0; i < tempc - 1; i++) {
					newl[end[0]][end[1] - i] = l[end[0]][end[1] - i - 1];
				}
				for(int i = 0; i < tempr - 1; i++) {
					newl[end[0] - i][start[1]] = l[end[0] - i - 1][start[1]];
				}
				start[0]++;
				start[1]++;
				end[0]--;
				end[1]--;
				tempr -= 2;
				tempc -= 2;
				if(tempr == 0 || tempc == 0) {
					break;
				}
			}
			l = newl;	
		}

		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(l[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
