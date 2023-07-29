import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        ArrayList<List<Node>> cowList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            cowList.add(new ArrayList());
        }
        for(int i=0;i<m;i++){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cowList.get(info[0]).add(new Node(info[1],info[2]));
            cowList.get(info[1]).add(new Node(info[0],info[2]));
        }
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,2147000000);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[1] = 0;
        queue.offer(new Node(1,0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(!visit[node.num]) visit[node.num] = true;
            else continue;
            List<Node> nodes = cowList.get(node.num);
            for (Node nn : nodes) {
                if(dist[nn.num]>dist[node.num]+ nn.cost){
                    dist[nn.num] = dist[node.num]+nn.cost;
                    queue.offer(new Node(nn.num,dist[nn.num]));
                }
            }
        }
        System.out.println(dist[n]);

    }
}
