class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        double avg = (double) sum/arr.length;
        return avg;
    }
}