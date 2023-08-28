import java.util.*;
class Solution {
    class Mentoring{
        int startTime;
        int endTime;
        
        Mentoring(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    ArrayList<ArrayList<Mentoring>> mentoringList = new ArrayList<>();
    public int solution(int k, int n, int[][] reqs) {
        for(int i=0;i<=k+1;i++){
            mentoringList.add(new ArrayList<>());
        }
        for(int i=0;i<reqs.length;i++){
            mentoringList.get(reqs[i][2]).add(new Mentoring(reqs[i][0],reqs[i][1]+reqs[i][0]));
        }
        int[][] waitngTimeList = new int[k+1][n+1];
        for(int i=1;i<=k;i++){
            List<Mentoring> currentCategoryList = mentoringList.get(i);
            if (currentCategoryList.size() == 0) continue;
            for(int j=1;j<=n-k+1;j++){
                int waitingTime = calculateWaitingTime(currentCategoryList,j);
                waitngTimeList[i][j] = waitingTime;
            }
        }
        int[] mentorCountArr = new int[k+1];
        for(int i=1;i<=k;i++){
            mentorCountArr[i] = 1;
        }
        int remainMentor = n-k;
        while(remainMentor-- > 0){
            int time = 0;
            int maxCategoryIdx = 0;
            for(int j=1;j<=k;j++){
                int currentWaitingTime = waitngTimeList[j][mentorCountArr[j]];
                int plusMentorWaitingTime = waitngTimeList[j][mentorCountArr[j]+1];
                if(time<=Math.abs(currentWaitingTime-plusMentorWaitingTime)){
                    time = Math.abs(currentWaitingTime-plusMentorWaitingTime);
                    maxCategoryIdx = j;
                }
            }
            if(time==0) break;
            mentorCountArr[maxCategoryIdx]++;
        }
        int answer = 0;
        for(int i=1;i<=k;i++){
                answer+=calculateWaitingTime(mentoringList.get(i),mentorCountArr[i]);
            }
        return answer;
    }
    public int calculateWaitingTime(List<Mentoring> li, int mentorSize){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        int waitTime = 0;

        for (Mentoring m : li) { 
            if (pq.isEmpty() || pq.size() < mentorSize) { 
                pq.add(m.endTime);
            } else {
                int earlyConsultEndTime = pq.poll();

                if (m.startTime < earlyConsultEndTime) { 
                    waitTime += (earlyConsultEndTime - m.startTime);
                    pq.add(earlyConsultEndTime + m.endTime-m.startTime);
                } else {
                    pq.add(m.endTime); 
                }
            }
        }
        return waitTime;
    }
}