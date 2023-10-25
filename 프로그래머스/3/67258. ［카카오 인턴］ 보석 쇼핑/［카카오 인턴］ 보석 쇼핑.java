import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int dist = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String,Integer> map = new HashMap<>();
        while(true){
            if(map.size()==set.size()){
                map.put(gems[left],map.get(gems[left])-1);
                if(map.get(gems[left])==0) map.remove(gems[left]);
                left++;
            }
            else if(right == gems.length) break;
            else{
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            if(map.size()==set.size()){
                if(right-left < dist){
                    dist = right-left;
                    start = left+1;
                    end = right;
                }
            }            
        }
        int[] answer = new int[]{start,end};
        return answer;
    }
}