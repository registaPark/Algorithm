import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] parent;
    static class Edge{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0]; m = arr[1];
        parent = new int[n+1];
        char[] university = new char[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            university[i+1] = st.nextToken().charAt(0);
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((e1,e2)->e1.cost-e2.cost);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            q.add(new Edge(s,e,c));
        }
        for(int i=1;i<=n;i++) parent[i] = i;
        int count = 0;
        int costs = 0;
        while (!q.isEmpty()){
            Edge edge = q.poll();
            if(find(edge.start)!=find(edge.end)){
                if(university[edge.start]!=university[edge.end]){
                    count++;
                    costs+=edge.cost;
                    union_parent(edge.start,edge.end);
                }
            }
        }
        costs = count!=n-1 ? -1 : costs;
        System.out.println(costs);
    }

    private static void union_parent(int start, int end) {
        int s = find(start);
        int e = find(end);
        if(s!=e){
            parent[e] = s;
        }
    }

    private static int find(int c) {
        if(parent[c]==c){
            return c;
        }
        return parent[c] = find(parent[c]);
    }


}
