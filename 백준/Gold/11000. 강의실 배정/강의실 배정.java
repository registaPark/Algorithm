import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> b = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<n;i++){
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            b.add(a);
        }
        PriorityQueue<Integer> objects = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        objects.add(0);
        for(int i=0;i<n;i++){
            int[] poll = b.poll();
            Integer poll1 = objects.poll();
            if(poll[0]>=poll1){
                objects.add(poll[1]);
            }
            else{
                objects.add(poll1);
                objects.add(poll[1]);
            }

        }
        System.out.println(objects.size());
    }
}