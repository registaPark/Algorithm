import java.util.*;
class Solution {
    HashMap<Long,Long> map = new HashMap<>();
    long[] answer;
    public long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        for(int i=0;i<room_number.length;i++){
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }
    public long findRoom(long number){
        if(!map.containsKey(number)){
            map.put(number,number+1);
            return number;    
        }
        long empty = findRoom(map.get(number));
        map.put(number,empty);
        return empty;
    }
}