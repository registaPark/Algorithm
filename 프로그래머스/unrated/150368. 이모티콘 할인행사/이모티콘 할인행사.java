class Solution {
    int[][] users;
    int[] emoticons;
    int[] sales;
    int size;
    int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        size = emoticons.length;
        sales = new int[size];
        dfs(0);
        return answer;
    }
    public void dfs(int c){
        if(c==size){
            int plus = 0;
            int noPlus = 0;
            for(int i=0;i<users.length;i++){
                int money=0;
                for(int j=0;j<size;j++){
                    if(users[i][0]<=sales[j]){
                        money+=(emoticons[j]/100)*(100-sales[j]);
                    }
                }
                if(money>=users[i][1]){
                    plus++;
                }else{
                    noPlus+=money;
                }
            }
            if(answer[0]<plus){
                answer[0] = plus;
                answer[1] = noPlus;
            }
            if(answer[0]==plus){
                answer[1] = Math.max(noPlus,answer[1]);
            }
            return;
        }
        for(int i=10;i<=40;i+=10){
            sales[c] = i;
            dfs(c+1);
        }
    }
}