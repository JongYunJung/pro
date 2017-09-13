import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [][] d;
	static int [][] t;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			d = new int [N+1][M+1];
			t = new int [N+1][M+1];;
			for(int i = 1; i<=N; i++)
			{
				for(int j=1; j<=M; j++)
				{
					t[i][j] = sc.nextInt();
				}
			}
			find();
			System.out.println("#"+tc+" "+d[N][M]);
		}
	}
	public static void find()
	{
		d[1][1] = t[1][1];
		for (int j = 2; j <= M; j++)
			d[1][j] = d[1][j - 1] + t[1][j];
		for (int i = 2; i <= N; i++)
			d[i][1] = d[i - 1][1] + t[i][1];
		for (int i = 2; i <= N; i++)
		{
			for (int j = 2; j <= M; j++)
			{
				d[i][j] = (d[i - 1][j] < d[i][j - 1] ? d[i - 1][j] : d[i][j - 1]) + t[i][j];
			}
		}
	}
	
}
