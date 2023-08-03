import java.io.*;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Cnt = 0 , o2Cnt = 0;
                while (o1Cnt<o1.length() && o2Cnt<o2.length()){
                    char o1Char = o1.charAt(o1Cnt);
                    char o2Char = o2.charAt(o2Cnt);
                    StringBuilder o1Str = new StringBuilder();
                    StringBuilder o2Str = new StringBuilder();
                    if(Character.isDigit(o1Char) && Character.isDigit(o2Char)){
                        while(o1Cnt<o1.length() && Character.isDigit(o1.charAt(o1Cnt))){
                            o1Str.append(o1.charAt(o1Cnt));
                            o1Cnt++;
                        }
                        while (o2Cnt<o2.length() && Character.isDigit(o2.charAt(o2Cnt))){
                            o2Str.append(o2.charAt(o2Cnt));
                            o2Cnt++;
                        }
                        o1Cnt--;
                        o2Cnt--;
                        BigInteger o1Num = new BigInteger(o1Str.toString());
                        BigInteger o2Num = new BigInteger(o2Str.toString());
                        if(o1Num.equals(o2Num)){
                            if(o1Str.length()>o2Str.length()) return 1;
                            if(o1Str.length()<o2Str.length()) return -1;
                            o1Cnt++;
                            o2Cnt++;
                        }else{
                            if(o1Num.compareTo(o2Num) > 0) return 1;
                            else return -1;
                        }
                    }
                    else if(Character.isDigit(o1Char) && !Character.isDigit(o2Char)) return -1;
                    else if(!Character.isDigit(o1Char) && Character.isDigit(o2Char)) return 1;
                    else if(!Character.isDigit(o1Char) && !Character.isDigit(o2Char)){
                        if(o1Char==o2Char){
                            o1Cnt++;
                            o2Cnt++;
                        }else{
                            char upperO1Char = Character.toUpperCase(o1Char);
                            char upperO2Char = Character.toUpperCase(o2Char);
                            if(upperO1Char==upperO2Char){
                                if(o1Char==upperO1Char) return -1;
                                return 1;
                            }
                            return (int) upperO1Char - (int) upperO2Char;
                        }
                    }
                }
                if(o1.length()>o2.length()) return 1;
                else if(o1.length()<o2.length()) return -1;
                return 0;
            }
        });
        for(int i=0;i<n;i++){
            queue.add(br.readLine());
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
