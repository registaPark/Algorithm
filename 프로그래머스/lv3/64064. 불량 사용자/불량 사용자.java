import java.util.*;
class Solution {
    boolean[] visit;
    String[] banned_id;
    String[] user_id;
    int count = 0;
    HashSet<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visit = new boolean[user_id.length];
        this.banned_id = banned_id;
        this.user_id = user_id;
        back_tracking(0);
        return set.size();
    }
    public void back_tracking(int cnt){
        if(cnt==banned_id.length){
            String str = "";
            for(int i=0;i<visit.length;i++){
                if(visit[i]){
                    str+=String.valueOf((char) i);
                }
            }
            set.add(str);
            return;
        }
        for(int i=0;i<user_id.length;i++){
            if(user_id[i].length()!=banned_id[cnt].length()) continue;
            if(visit[i]) continue;
            boolean flag = true;
            for(int j=0;j<user_id[i].length();j++){
                if(banned_id[cnt].charAt(j)=='*') continue;
                if(banned_id[cnt].charAt(j)!=user_id[i].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                visit[i] = true;
                back_tracking(cnt+1);
                visit[i] = false;
            }
        }
    }
}