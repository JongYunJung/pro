#include <stdio.h>

int p[3001];
int t[3001][3];
int N;

int rep(int n);
int find(void);

int main(void)
{
	int T;
	//freopen("Text.txt", "r", stdin);
	scanf("%d", &T);
	for (int tc = 1; tc <= T; tc++)
	{
		scanf("%d", &N);
		for (int i = 1; i <= N; i++)
			p[i] = i;
		for (int i = 1; i <= N; i++)
		{
			scanf("%d %d %d", &t[i][0], &t[i][1], &t[i][2]);
		
		}
		printf("%d\n", find());
	}
}

int rep(int n)
{
	while (p[n] != n)
	{
		n = p[n];
	}
	return n;
}

int find(void)
{
	for (int i = 1; i < N; i++)
	{
		int repi = rep(i);
		for (int j = i + 1; j <= N; j++)
		{
			int a = t[i][0] - t[j][0];
			int b = t[i][1] - t[j][1];
			int c = t[i][2] + t[j][2];
			if ((a*a + b*b) <= (c*c))
			{
				p[rep(j)] = repi;
			}
		}
	}
	int cnt = 0;
	for (int i = 1; i <= N; i++)
	{
		if (p[i] == i)
			cnt++;
	}
	return cnt;
}
