import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        isPrime();
        int minVal = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=n;i<=m;i++){
            if(!prime[i]){
                minVal = Math.min(minVal,i);
                sum+=i;
            }
        }
        if(minVal==Integer.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(minVal);
        }
    }

    private static void isPrime() {
        prime[0] = true;
        prime[1] = true;
        for(int i=2;i<Math.sqrt(prime.length);i++){
            for(int j=i*i;j<prime.length;j+=i){
                prime[j] = true;
            }
        }
    }
}
