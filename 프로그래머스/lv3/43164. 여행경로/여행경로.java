import java.util.*;
class Solution {
    boolean[] visit;
    int size;
    String[] res;
    class Ticket{
        String start;
        String end;
        public Ticket(String start,String end){
            this.start = start;
            this.end = end;
        }
    }
    List<Ticket> ticketList = new ArrayList<>();
    PriorityQueue<String> q = new PriorityQueue<>();
    public String[] solution(String[][] tickets) {
        for(int i=0;i<tickets.length;i++){
            ticketList.add(new Ticket(tickets[i][0],tickets[i][1]));
        }
        visit = new boolean[tickets.length];
        size = tickets.length;
        res = new String[size+1];
        back_tracking(0,"ICN");
        String result = q.poll();
        return result.split(" ");
    }
    public void back_tracking(int cnt,String start){
        if(cnt==size){
            res[size] = start; 
            String str = "";
            for(int i=0;i<=size;i++){
                str+=res[i];
                str+=" ";
            }
            q.add(str);
            return;
        }
        for(int i=0;i<size;i++){
            if(!visit[i] && start.equals(ticketList.get(i).start)){
                visit[i] = true;
                res[cnt] = start;
                back_tracking(cnt+1,ticketList.get(i).end);
                visit[i] = false;
                res[cnt] = "";
            }
        }
    }
}