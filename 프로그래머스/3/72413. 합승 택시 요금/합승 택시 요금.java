import java.util.Arrays;

class Solution {
    static final int MAX = 20000001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], MAX);
            dp[i][i] = 0;
        }

        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }


        int answer = dp[s][a] + dp[s][b];
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] +dp[i][b]);
        }
        return answer;
    }
}