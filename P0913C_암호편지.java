import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [][] d1;
	static int [][] d2;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		String str2 = "today";
		String str3 = "tomorrow";		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			String str1 = sc.next();

			d1 = new int [str1.length()+1][str2.length()+1];
			d2 = new int [str1.length()+1][str3.length()+1];
			for(int i = 1; i<=str1.length(); i++)
			{
				for(int j = 1; j<=str2.length(); j++)
				{
					if(str1.charAt(i-1)==str2.charAt(j-1))
					{
						d1[i][j] = d1[i-1][j-1]+1;
					}
					else
					{
						d1[i][j] = (d1[i-1][j]>d1[i][j-1])?d1[i-1][j]:d1[i][j-1];
					}
				}
			}
			for(int i = 1; i<=str1.length(); i++)
			{
				for(int j = 1; j<=str3.length(); j++)
				{
					if(str1.charAt(i-1)==str3.charAt(j-1))
					{
						d2[i][j] = d2[i-1][j-1]+1;
					}
					else
					{
						d2[i][j] = (d2[i-1][j]>d2[i][j-1])?d2[i-1][j]:d2[i][j-1];
					}
				}
			}
			if(d1[str1.length()][str2.length()]==str2.length())
				System.out.println("#"+tc+" today");
			else if(d2[str1.length()][str3.length()]==str3.length())
				System.out.println("#"+tc+" tomorrow");
			else
				System.out.println("#"+tc+" none");
		}
	}
}
