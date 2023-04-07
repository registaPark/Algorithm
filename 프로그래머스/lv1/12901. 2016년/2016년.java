class Solution {
    public String solution(int a, int b) {
        String[] arr ={"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int day = b;
        for(int i=1;i<a;i++){
            if(i==2){
                day+=29;
            }
            else if(i==4 || i==6 || i==9 || i==11){
                day+=30;
            }
            else{
                day+=31;
            }
        }
                
        System.out.println(day);
        return arr[(day+4)%7];
        
    }
}