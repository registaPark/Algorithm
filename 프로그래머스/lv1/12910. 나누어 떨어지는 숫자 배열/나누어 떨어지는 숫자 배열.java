import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int a : arr){
            if(a%divisor==0) array.add(a);
        }
        if(array.size()==0) array.add(-1);
        int[] answer = new int[array.size()];
        for(int i=0;i<array.size();i++){
            answer[i]=array.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}