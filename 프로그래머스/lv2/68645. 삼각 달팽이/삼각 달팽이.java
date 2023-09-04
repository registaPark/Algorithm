class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int y=-1;
        int x=0;
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i%3==0){
                    y++;
                }
                else if(i%3==1){
                    x++;
                }
                else if(i%3==2){
                    x--;
                    y--;
                }
                board[y][x]=num;
                num++;
            }
        }
        int[] arr = new int[n*(n+1)/2];
        int a = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    break;
                }
                else{
                    arr[a]=board[i][j];
                    a++;
                }
            }
        }
        return arr;
    }
}