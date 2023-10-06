import java.util.*;
class Solution {
    int[] stones;
    int k;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;
        int answer = 0;
        int lt = 0;
        int rt = 200000000;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(canCross(mid)){
                lt = mid+1;
                answer = Math.max(answer,mid);
            }else{
                rt = mid-1;
            }
        }
        return answer;
    }
    public boolean canCross(int mid){
        int gage = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]-mid<0) gage++;
            else gage = 0;
            if(gage==k) return false;
        }
        return true;
    }
}