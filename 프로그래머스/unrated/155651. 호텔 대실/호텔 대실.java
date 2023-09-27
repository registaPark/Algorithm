import java.util.*;
class Solution {
    class Book{
        int startTime;
        int endTime;
        public Book(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Book> q = new PriorityQueue<>((b1,b2)->{
            return b1.startTime-b2.startTime;
        });
        for(int i=0;i<book_time.length;i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            String[] startSplit = start.split(":");
            String[] endSplit = end.split(":");
            int startTime = (Integer.parseInt(startSplit[0]) * 60) + Integer.parseInt(startSplit[1]);
            int endTime = (Integer.parseInt(endSplit[0]) * 60) + Integer.parseInt(endSplit[1]);
            q.add(new Book(startTime,endTime));
        }
        PriorityQueue<Integer> timeQ = new PriorityQueue<>();
        int cnt=0;
        while(!q.isEmpty()){
            Book book = q.poll();
            if(!timeQ.isEmpty()){
                Integer time = timeQ.poll();
                if(time+10>book.startTime){
                    cnt++;
                    timeQ.add(book.endTime);
                    timeQ.add(time);
                }else{
                    timeQ.add(book.endTime);
                }
            }else{
                cnt++;
                timeQ.add(book.endTime);
            }
        }
        return cnt;
    }
}