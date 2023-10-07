import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long dist = 0;
        Stack<Integer> ds = new Stack<>();
        Stack<Integer> ps = new Stack<>();
        for(int i=0;i<n;i++){
            ds.push(deliveries[i]);
            ps.push(pickups[i]);
        }
        while(!ds.isEmpty() || !ps.isEmpty()){
            while(!ds.isEmpty() && ds.peek() == 0){
                ds.pop();
            }
            while(!ps.isEmpty() && ps.peek() == 0){
                ps.pop();
            }
            dist += 2*Math.max(ds.size(),ps.size());
            int p = 0;
            while(!ds.isEmpty()){
                int current = ds.pop();
                if(p + current <= cap){
                    p+=current;
                }else{
                    ds.push(p+current-cap);
                    break;
                }
            }
            p = 0;
            while(!ps.isEmpty()){
                int current = ps.pop();
                if(p + current <= cap){
                    p+=current;
                }else{
                    ps.push(p+current-cap);
                    break;
                }
            }
        }
        return dist;
    }
}