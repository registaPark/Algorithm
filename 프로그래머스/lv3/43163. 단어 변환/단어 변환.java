import java.util.*;
class Solution {
    int minCount= Integer.MAX_VALUE;
    boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        DFS(begin,target,words,0);
        if(minCount==Integer.MAX_VALUE) return 0;
        return minCount;
    }
    public void DFS(String begin,String target,String[] words,int cnt){
        if(cnt>=words.length) return;
        if(begin.equals(target)){
            if(minCount>cnt){
                minCount = cnt;
                return;
            }
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!visit[i]){
                int count = 0;
               for(int j=0;j<begin.length();j++){
                   if(begin.charAt(j)!=words[i].charAt(j)) count++;
               }
                if(count==1){
                    visit[i] = true;
                    DFS(words[i],target,words,cnt+1);
                    visit[i] = false;
                }
            }
        }
    }
}