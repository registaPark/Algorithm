class Solution {
    int[][] map;
    int size;
    int[][] lock;
    int[][] key;
    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;
        int m = key.length;
        int n = lock.length;
        size = lock.length + (key.length * 2) - 2;
        map = new int[size][size];
        for(int i=m-1;i<n+m-1;i++){
            for(int j=m-1;j<n+m-1;j++){
                map[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        for(int i=0;i<4;i++){
            if(check(m,n)) return true;
            rotate(m);
        }
        return false;
    }
    public boolean check(int m,int n){
        int[][] cloneMap = map.clone();
        for(int i=0;i<size-m+1;i++){
            for(int j=0;j<size-m+1;j++){
                for(int k=0;k<m;k++){
                    for(int t=0;t<m;t++){
                        cloneMap[i+k][j+t] += key[k][t];
                    }
                }
                boolean flag = true;
                for(int k=m-1;k<n+m-1;k++){
                    for(int t=m-1;t<n+m-1;t++){
                        if(cloneMap[k][t]!=1){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }
                if(flag) return true;
                for(int k=0;k<m;k++){
                    for(int t=0;t<m;t++){
                        cloneMap[i+k][j+t] -= key[k][t];
                    }
                }
            }
        }
        return false;
    }
    public void rotate(int m){
        int[][] temp = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                temp[i][j] = key[m-1-j][i];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                key[i][j] = temp[i][j];
            }
        }
    }
}