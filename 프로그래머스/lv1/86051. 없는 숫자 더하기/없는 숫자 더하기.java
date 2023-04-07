import java.util.*;
 
class Solution {
    public int solution(int[] numbers) {
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            li.add(numbers[i]);
        }
        int answer = 0;
        for(int i=0;i<10;i++){
            if(!li.contains(i)){
                answer+=i;
            }
            
        }
        return answer;
    }
}