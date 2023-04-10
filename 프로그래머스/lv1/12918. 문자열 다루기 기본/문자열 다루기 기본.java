class Solution {
    public static boolean isNumeric(String str) {
    return str.matches("\\d+");
}
    public boolean solution(String s) {
        if(s.length()==4 || s.length()==6){
            if(isNumeric(s)) return true;
            return false;
        }
        return false;
    }
}