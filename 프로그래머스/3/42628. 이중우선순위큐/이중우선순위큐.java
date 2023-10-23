import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>((o1,o2)-> o2-o1);
        for(int i=0;i<operations.length;i++){
            String[] opers = operations[i].split(" ");
            int num = Integer.parseInt(opers[1]);
            if(opers[0].equals("I")){
                q1.add(num);
                q2.add(num);
            }
            else if(opers[0].equals("D")){
                if(num==-1 && !q1.isEmpty() && !q2.isEmpty()){
                    int poll = q1.poll();
                    q2.remove(poll);
                }
                else if(num==1 && !q1.isEmpty() && !q2.isEmpty()){
                    int poll = q2.poll();
                    q1.remove(poll);
                }
            }
        }
        int[] answer = new int[2];
        if(!q2.isEmpty()) answer[0] = q2.poll();
        if(!q1.isEmpty()) answer[1] = q1.poll();
        return answer;
    }
}