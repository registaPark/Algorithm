import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int index = 0;
        int count = 0;
        int end = 0;
        int total = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end){
                pq.add(jobs[index++]);
            }
            if(pq.isEmpty()){
                end = jobs[index][0];
            } else{
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        
        
        return (int) total /jobs.length;
    }
}