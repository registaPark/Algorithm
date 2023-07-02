import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] visited = new int[n+1];
        Arrays.fill(visited,-100);
        for(int i=0;i<edge.length;i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        visited[1]=0;
        while(!queue.isEmpty()){
            int p = queue.poll();
            for(int i=0;i<graph.get(p).size();i++){
                if(visited[graph.get(p).get(i)]<0){
                    visited[graph.get(p).get(i)]=visited[p]+1;
                    queue.add(graph.get(p).get(i));
                }
            }
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(visited[i]==Arrays.stream(visited).max().getAsInt()) answer++;
        }
        return answer;
    }
    
}