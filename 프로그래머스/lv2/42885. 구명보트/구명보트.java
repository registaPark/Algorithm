import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(people);
        for(int i=0;i<people.length;i++){
            deque.add(people[i]);
        }
        int count=0;
        while(!deque.isEmpty()){
            int tot = deque.pollLast();
            count++;
            if(limit>=tot){
                while(!deque.isEmpty()){
                    if(limit>=deque.getFirst()+tot){
                    tot+=deque.pollFirst();
                    }else{
                        break;  
                    }                 
                }
                
            }
            
        }
        return count;
    }
}