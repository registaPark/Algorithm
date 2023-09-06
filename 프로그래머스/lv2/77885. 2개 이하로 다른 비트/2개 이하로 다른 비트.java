class Solution {
    static int[] arr;
    static long[] result;
    public long[] solution(long[] numbers) {
        result = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long number = numbers[i];
            int count=0;
            long a = 1;
            while(true){
            if(a>number){
                break;
            }
            a*=2;
            count++;
            }
            arr = new int[count+1];
            divide(number,count);
            for(int j=arr.length-1;j>=0;j--){
            if(arr[j]==0){
                arr[j]=1;
                for(int k=j+1;k<arr.length;k++){
                    if(arr[k]==1){
                        arr[k]=0;
                        break;
                    }
                }
                break;
            }
        }
            long sum=0;
            for(int j=0;j<=arr.length-1;j++){
                sum+=arr[j]*Math.pow(2,count);
                count--;
            }
            result[i]= sum;
        }
        
        return result;
    }
    
    private static void divide(long x,int count){
        if(x==0){
            return;
        }
        long b = x%2;
        divide(x/2,count-1);
        arr[count]=Long.valueOf(b).intValue();
    }
}