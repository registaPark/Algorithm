import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());

        int[][] drink=new int[N][2];

        int lsum=0;
        int rsum=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            drink[i][0]=a;
            drink[i][1]=b;

            lsum+=drink[i][0];
            rsum+=drink[i][1];
        }

        int left=0;
        int right=T;

        if(lsum>T || rsum<T){
            System.out.println(-1);
            System.exit(0);
        }

        while(left<=right){
            int mid=(left+right)/2;
            int sum=0;

            boolean flag=false;
            for(int i=0;i<N;i++){
                if(drink[i][0]>mid){
                    flag=true;
                    break;
                }
                sum+=Math.min(drink[i][1],mid);
            }

            if(flag){
                left=mid+1;
                continue;
            }

            if(sum>=T){
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }

        System.out.println(left);
    }
}