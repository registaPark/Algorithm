import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((l1,l2)->l2-l1);
        for(int i=0;i<works.length;i++){
            q.add(works[i]);
        }
        for(int i=0;i<n;i++){
            if(q.isEmpty()) break;
            int current = q.poll();
            if(current>0) q.add(current-1);
            
        }
        while(!q.isEmpty()){
            answer+=(long) Math.pow(q.poll(),2);
            
        }
        
        return answer;
    }
}