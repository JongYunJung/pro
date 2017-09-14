import java.io.FileInputStream;
import java.util.*;
public class Solution {
	static int [][] d;
	static int [] p;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		d = new int [N+1][N+1];
		p = new int [N+1];
		for(int i = 1; i<=N; i++)
		{
			p[i] = sc.nextInt();
		}
		
		for(int i = 1; i<=N; i++)
		{
			for(int j = 1; j<=N; j++)
			{
				if(i>j)
					d[i][j] = d[i-1][j];
				else
					d[i][j] = d[i-1][j]>(d[i][j-i]+p[i])?d[i-1][j]:(d[i][j-i]+p[i]);
			}
		}
		System.out.println(d[N][N]);
	}
}
