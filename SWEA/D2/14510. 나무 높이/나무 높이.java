

import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int test =1 ;test<=t;test++) {
			int n = Integer.parseInt(br.readLine());
			int height =0;
			int[] tree= new int[n];
			int max=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n;i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				height = Math.max(tree[i], height);
			}
			int one =0;
			int two=0;
			for(int i=0; i<n;i++) {
				if(tree[i]==height)continue;
				int diff = height - tree[i];
				one +=diff%2;
				two += diff/2;
			}
			while(two>one+1) {
				two--;
				one+=2;
			}
			System.out.println("#"+test+" "+Math.max(one*2-1, two*2));
		}

	}

}
