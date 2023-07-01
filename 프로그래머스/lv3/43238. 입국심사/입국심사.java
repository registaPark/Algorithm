import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        if(times.length==1){
            return times[0]*n;
        }
        Arrays.sort(times);
        long lt= 1;
        long rt = (long) times[times.length-1]*n;
        
        while(lt<=rt){
            long mid = (lt+rt)/2;
            long a = 0;
            for(int i=0;i<times.length;i++){
                a+=mid/times[i];
                if(a>n) break;
            }
            if(a>=n){
                rt = mid-1;
            }
            else{
                lt = mid+1;
            }
        }
        long answer = lt;
        return answer;
    }
}