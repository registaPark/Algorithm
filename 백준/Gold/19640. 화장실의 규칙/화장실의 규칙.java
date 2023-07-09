import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Worker{
        int idx;
        int degree;
        int workDays;
        boolean decka;

        public Worker(int idx,int degree, int workDays,boolean d) {
            this.idx = idx;
            this.degree = degree;
            this.workDays = workDays;
            this.decka = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Queue<Worker>> queueList = new ArrayList<>();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];

        for(int i=0; i<m; i++) queueList.add(new LinkedList<>());
        for(int i=0;i<n;i++){
            Queue<Worker> workers1 = queueList.get(i % m);
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(i==k) workers1.add(new Worker(i%m,arr[1],arr[0],true));
            else workers1.add(new Worker(i%m,arr[1],arr[0],false));
        }
        int cnt=0;
        PriorityQueue<Worker> workers = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                if(o1.workDays==o2.workDays){
                    if(o1.degree==o2.degree){
                        return o1.idx-o2.idx;
                    }
                    return o2.degree-o1.degree;
                }else{
                    return o2.workDays-o1.workDays;
                }
            }
        });
        for(int i=0;i<m;i++){
            if(!queueList.get(i).isEmpty()){
                Worker worker = queueList.get(i).peek();
                workers.add(worker);
            }
        }
        while (!workers.isEmpty()){
            Worker poll = workers.poll();
            Queue<Worker> workers1 = queueList.get(poll.idx);
            workers1.poll();
            if(!workers1.isEmpty()) workers.add(workers1.peek());
            if(poll.decka){
                System.out.println(cnt);
                break;
            }
            cnt++;
        }
    }
}
