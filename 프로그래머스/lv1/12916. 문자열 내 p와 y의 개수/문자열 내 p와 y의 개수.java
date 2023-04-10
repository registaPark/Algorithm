class Solution {
    boolean solution(String s) {
        int pcnt=0;
        int ycnt=0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p') pcnt++;
            if(s.charAt(i)=='y') ycnt++;
        }
        if(pcnt==ycnt) return true;
        return false;
    }
}