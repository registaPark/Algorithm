import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n>s) return new int[]{-1};
        int init = s/n;
        int mod = s%n;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = init;
        }
        for(int i=0,m=n-1;i<mod;i++,m--){
            answer[m]++;
        }
        return answer;
    }
}