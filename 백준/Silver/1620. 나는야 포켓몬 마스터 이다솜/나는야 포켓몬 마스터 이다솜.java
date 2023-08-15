import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        HashMap<BigInteger, Integer> poketmonMap1 = new HashMap<>();
        HashMap<Integer, String> poketmonMap2 = new HashMap<>();
        for(int i=0;i<n;i++){
            String poketmon = br.readLine();
            String key = "";
            for(int j=0;j<poketmon.length(); j++){
                int a;
                a = poketmon.charAt(j);
                key+=a;
            }
            poketmonMap1.put(new BigInteger(key),i+1);
            poketmonMap2.put(i+1,poketmon);
        }
        for(int i=0;i<m;i++){
            String poketmon = br.readLine();
            if(Character.isDigit(poketmon.charAt(0))){
                System.out.println(poketmonMap2.get(Integer.parseInt(poketmon)));
            }else{
                String key = "";
                for(int j=0;j<poketmon.length();j++){
                    int a;
                    a = poketmon.charAt(j);
                    key+=a;
                }
                System.out.println(poketmonMap1.get(new BigInteger(key)));
            }
        }
    }
}
