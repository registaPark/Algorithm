import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int busTime = 540;
        PriorityQueue<Integer> crews = new PriorityQueue<>();
        for(int i=0;i<timetable.length;i++){
            String[] strs = timetable[i].split(":");
            int tt = Integer.parseInt(strs[0])*60+Integer.parseInt(strs[1]);
            crews.add(tt);
        }
        int result=n*m;
        int lastCrew = 0;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++){
                if(!crews.isEmpty()){
                    if(crews.peek()<=busTime){
                        lastCrew = crews.poll();
                        cnt++;
                    }   
                }
            }
            if(i==n-1 && cnt==m){
                int corn = lastCrew-1;
            int hour = corn/60;
            int min = corn%60;
            String hStr = "0";
            String hourStr = Integer.toString(hour);
            String minStr = Integer.toString(min);
            if(hourStr.length()==1){
                hourStr = hStr+hourStr;
            }
            if(minStr.length()==1){
                minStr = hStr+minStr;
            }
            String time = hourStr+":"+minStr;
            return time;
            }else if(i==n-1){
            int hour = busTime/60;
            int min = busTime%60;
            String hStr = "0";
            String hourStr = Integer.toString(hour);
            String minStr = Integer.toString(min);
            if(hourStr.length()==1){
                hourStr = hStr+hourStr;
            }
            if(minStr.length()==1){
                minStr = hStr+minStr;
            }
            String time = hourStr+":"+minStr;
            return time;
            }
            busTime+=t;
        }
        
        String answer = "";
        return answer;
    }
}