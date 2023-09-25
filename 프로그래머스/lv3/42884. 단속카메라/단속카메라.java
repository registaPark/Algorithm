import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int lastCam = -30001;
        int cnt = 0;
        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return Integer.compare(o1[1],o2[1]);
            }
        });
        for(int i=0;i<routes.length;i++){
            if(routes[i][0]<=lastCam && routes[i][1]>=lastCam){
                continue;
            }else{
                cnt++;
                lastCam = routes[i][1];
            }
        }
        
        return cnt;
    }
}