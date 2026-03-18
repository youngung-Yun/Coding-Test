
import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		for(int i=0; i<n;i++) {
			String s = br.readLine();
			for(int j=0; j<m;j++) {
					map[i][j] = s.charAt(j);
			}
		}
		int min =Integer.MAX_VALUE;
		for(int i=0; i<=n-8;i++) {
			for(int j=0;j<=m-8;j++) {
				
				int countB=0;
				int countW=0;
				
				for(int row=0; row<8;row++) {
					for(int col =0; col<8;col++) {
						if((row+col)%2==0) {
							if(map[row+i][col+j]!='W')countW++;
							if(map[row+i][col+j]!='B')countB++;
						}else {
							if(map[row+i][col+j]!='B')countW++;
							if(map[row+i][col+j]!='W')countB++;
						}
						
					}
				}
				min = Math.min(min,Math.min(countW, countB));
				
				
			}
		}
		System.out.println(min);
		
	}

	

}
