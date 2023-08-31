import java.util.*;
class Solution {
    int[] dist;
    List<List<Integer>> graph;
    int n;
    public int[] solution(int nn, int[][] roads, int[] sources, int destination) {
        n = nn;
        dist = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][1]).add(roads[i][0]);
            graph.get(roads[i][0]).add(roads[i][1]);
        }

        dijkstra(destination);
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            if(dist[sources[i]]==Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = dist[sources[i]];   
            }
        }
        return answer;
    }
    public void dijkstra(int start){
        dist[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.get(start).size();i++){
            q.add(graph.get(start).get(i));
            dist[graph.get(start).get(i)] = 1;
        }
        while(!q.isEmpty()){
            Integer current = q.poll();
            for(int i=0;i<graph.get(current).size();i++){
                Integer next = graph.get(current).get(i);
                if(dist[next]>dist[current]+1){
                    dist[next] = dist[current]+1;
                    q.add(next);
                }
            }
        }
    }
}