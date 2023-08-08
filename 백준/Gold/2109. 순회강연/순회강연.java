import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Lecture implements Comparable<Lecture>{
        int day;
        int pay;

        public Lecture(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.pay-this.pay;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] lectures = new boolean[10001];
        PriorityQueue<Lecture> q = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            q.add(new Lecture(s[1],s[0]));
        }
        int count = 0;
        while (!q.isEmpty()){
            Lecture lecture = q.poll();
            for(int i=lecture.day;i>=1;i--){
                if (!lectures[i]) {
                    lectures[i] = true;
                    count+=lecture.pay;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
