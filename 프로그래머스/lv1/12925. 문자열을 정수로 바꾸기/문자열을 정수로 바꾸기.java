class Solution {
    public int solution(String s) {
        int answer = 0;
        String a = "";
        if(Character.isDigit(s.charAt(0))){
            a = s.substring(0);
        }
        else{
            a = s.substring(1);    
        }
        answer = Integer.parseInt(a);
        if(s.substring(0,1).equals("-")){
            answer*=-1;
            return answer;    
        }
        return answer;
        
        
    }
}