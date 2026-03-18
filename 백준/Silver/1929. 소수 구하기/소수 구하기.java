
import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m =Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = m; i<=n;i++) {
			if(i<2)continue;
			boolean vf = true;
			for(int j=2;j*j<=i;j++) {
				if(i%j==0) {
					vf=false;
					break;
				}
				vf=true;
			}
			if(vf) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
		
	}

	

}
