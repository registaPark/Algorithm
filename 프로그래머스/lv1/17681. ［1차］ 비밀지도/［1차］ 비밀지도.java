import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] arr = new String[n];
        
        for(int i=0;i<arr1.length;i++){
            char[] a = new char[arr1.length];
            int k = 1;
            Arrays.fill(a,' ');
            int c = arr1[i];
            int d = arr2[i];
            while(k<=n){
                if(c%2==1 || d%2==1) a[n-k]='#';
                k++;
                c=c/2;
                d=d/2;
            }
            arr[i] = new String(a);
        }
        
        return arr;
    }
}