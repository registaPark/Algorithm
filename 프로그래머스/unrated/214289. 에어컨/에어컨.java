import java.util.*;
class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        // 온도가 t1보다 낮다면 온도 올려야함 , 온도가 t2보다 높다면 온도를 내려야함
        // a는 에어컨 켰을때 전력 , b는 에어컨 유지했을때 전력 , 에어컨을 끄면 실외온도에 가까이 다가감
        t1+=10;
        t2+=10;
        temperature+=10;
        int[][] dp = new int[onboard.length][51];
        for(int i=0;i<onboard.length;i++){
            for(int j=0;j<51;j++){
                dp[i][j] = 100 * 1000;
            }
        }
        dp[0][temperature] = 0;
        int flag = 1;
        if (temperature > t2) {
            flag = -1;
        }
        for(int i=1;i<onboard.length;i++){
            for(int j=0;j<51;j++){
                int minV = 100*1000;
                if (( onboard[i] == 1 && t1 <= j && j <= t2 ) || onboard[i] == 0) {
                    if (0 <= j+flag && j+flag <= 50) {
                        minV = Math.min(minV, dp[i-1][j+flag]);
                    }
                    if (j == temperature) {
                        minV = Math.min(minV, dp[i-1][j]);
                    }
                    if (0 <= j-flag && j-flag <= 50) {
                        minV = Math.min(minV, dp[i-1][j-flag] + a);
                    }
                    if (t1 <= j && j <= t2) {
                        minV = Math.min(minV, dp[i-1][j] + b);
                    }
                    dp[i][j] = minV;
                }
            }
        }
        int i = onboard.length-1;
        int answer = dp[i][0];
        for (int j = 1; j < 51; j++) {
            answer = Math.min(answer, dp[i][j]);
        }
        return answer;
    }
}