class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[3];
        int idx = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dartResult.length();i++){
            if(Character.isDigit(dartResult.charAt(i))){
                sb.append(dartResult.charAt(i));
            }
            else if(dartResult.charAt(i)=='#'){
                arr[idx]*=-1;
            }
            else if(dartResult.charAt(i)=='*'){
                if(idx>0){
                    arr[idx-1]*=2;
                }
                arr[idx]*=2;
            }
            else{
                idx++;
                arr[idx]=Integer.parseInt(sb.toString());
                if(dartResult.charAt(i)=='D'){
                    arr[idx]*=arr[idx];
                }
                else if(dartResult.charAt(i)=='T'){
                    arr[idx]*=(arr[idx]*arr[idx]);
                }    
                sb = new StringBuilder();
            }
        }
        int sum=0;
        for(int i=0;i<3;i++){
            sum+=arr[i];
        }
        return sum;
    }
}