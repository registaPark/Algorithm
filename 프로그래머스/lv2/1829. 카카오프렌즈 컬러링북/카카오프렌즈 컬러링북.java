import java.util.*;
class Solution {
    int[] dy = {0,1,0,-1};
    int[] dx = {1,0,-1,0};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[m][n];
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int divNum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0 && !visit[i][j]){
                    q.add(new int[]{i,j});
                    visit[i][j]=true;
                    int cnt=1;
                    while(!q.isEmpty()){
                        int[] current = q.poll();
                        int y = current[0];
                        int x = current[1];
                        for(int k=0;k<4;k++){
                            int yy = dy[k]+y;
                            int xx = dx[k]+x;
                            if(0<=yy && 0<=xx && yy<m && xx<n && !visit[yy][xx] && picture[yy][xx]==picture[current[0]][current[1]]){
                                q.add(new int[]{yy,xx});
                                visit[yy][xx]=true;
                                cnt++;
                            }
                        }
                    }
                    map.put(divNum,cnt);
                    divNum++;
                }
            }
        }
        numberOfArea = map.size();
        for(int i=0;i<map.size();i++){
            maxSizeOfOneArea = Math.max(map.get(i),maxSizeOfOneArea);
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}