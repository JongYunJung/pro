import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [][] d;
	static int [][] m;
	static int N;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			N = sc.nextInt();
			m = new int[N+1][N+1];
			d = new int[N+1][N+1];
			int k = 0;
			for(int i=1; i<=N; i++)
			{
				for(int j=1; j<=N; j++)
				{
					m[i][j]= (k++)%10+1;
				}
			}
			//d[1][1] = m[1][1];
			for(int i=1; i<=N; i++)
			{
				for(int j=1; j<=N; j++)
				{
					d[i][j]= d[i-1][j]+d[i][j-1]-d[i-1][j-1]+m[i][j];
				}
			}
			int sum = 0;
			for(int i=0; i<N; i++)
			{
				int r1 = sc.nextInt();
				int c1 = sc.nextInt();
				int r2 = sc.nextInt();
				int c2 = sc.nextInt();
				sum += d[r2][c2] - d[r2][c1-1]-d[r1-1][c2]+d[r1-1][c1-1];
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
