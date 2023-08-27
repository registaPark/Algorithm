import java.util.*;
class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(Character.isDigit(maps[i].charAt(j)) && !visit[i][j]){
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                    int cnt =Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                    while(!q.isEmpty()){
                        int[] pos = q.poll();
                        for(int k=0;k<4;k++){
                            int yy = pos[0] + dy[k];
                            int xx = pos[1] + dx[k];
                            if(0<=yy && yy<maps.length && 0<=xx && xx<maps[0].length() && !visit[yy][xx] && Character.isDigit(maps[yy].charAt(xx))){
                                q.add(new int[]{yy,xx});
                                cnt+=Integer.parseInt(String.valueOf(maps[yy].charAt(xx)));
                                visit[yy][xx] = true;
                            }
                        }
                    }
                    arr.add(cnt);
                }
            }
        }
        if(arr.size()==0) return new int[]{-1};
        else{
            int[] islandArr = new int[arr.size()];
            for(int i=0;i<arr.size();i++){
                islandArr[i] = arr.get(i);
            }
            Arrays.sort(islandArr);
            return islandArr;
        }
    }
}