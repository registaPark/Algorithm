import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0;i<moves.length;i++){
            int row = moves[i];
            for(int j=0;j<board.length;j++){
                int toy = board[j][row-1];
                if(toy!=0){
                    if(!stack.isEmpty()){
                        if(toy==stack.lastElement()){
                            answer+=2;
                            stack.pop();
                        }
                        else stack.push(toy);
                    }
                    else stack.push(toy);
                    board[j][row-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}