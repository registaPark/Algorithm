import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;
        char currentChar = str.charAt(0);
        if(currentChar=='0') zeroCnt++;
        else oneCnt++;
        for(int i=1;i<str.length(); i++){
            if(currentChar!=str.charAt(i)){
                if(currentChar == '0') oneCnt++;
                else zeroCnt++;
                currentChar = str.charAt(i);
            }
        }
        System.out.println(Math.min(zeroCnt,oneCnt));
    }
}
