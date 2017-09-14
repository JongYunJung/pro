import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [][] d;
	static int N;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			N = sc.nextInt();
			d = new int [N][2];
			
			d[0][0] = 0;
			d[0][1] = 1;
			for(int i=1; i<N; i++)
			{
				d[i][0] = d[i-1][1];
				d[i][1] = d[i-1][0] + d[i-1][1];
			}
			System.out.println("#"+tc+" "+(d[N-1][0]+d[N-1][1]));
		}
		
	}
}
