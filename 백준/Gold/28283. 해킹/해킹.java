import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    //BFS에서 사용할 InnerClass
    static class Info implements Comparable<Info>{
    	//idx : 컴퓨터 번호, time : 보안 시스템 설치 시간
        int idx, time;
        public Info(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
        //보안 시스템 설치시간 기준 오름차순 정렬
        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }
    //연결 회선 저장 리스트
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;	//보안 시스템 설치 확인 배열
    static int[] time, secureCom;	//설치 시간 및 초기 보안 컴퓨터 저장 배열
    static long[] money;	//분 당 금액 저장 배열
    static int N,Y;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 입력값 저장
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        money = new long[N+1];
        time = new int[N+1];
        secureCom = new int[Y+1];
        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine(), " ");
        //분 당 금액 저장
        for(int i=1;i<=N;i++)
            money[i] = Long.parseLong(st.nextToken());
            
        //양방향 회선 정보 저장
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            graph.get(c1).add(c2);
            graph.get(c2).add(c1);
        }
        st = new StringTokenizer(br.readLine()," ");
        //초기 보안 컴퓨터 저장
        for(int i=0;i<Y;i++)
            secureCom[i] = Integer.parseInt(st.nextToken());
        long result = 0;
        bfs();	//보안 시스템 기준 BFS 탐색
        //모든 수익 내림차순 정렬할 PriorityQueue
        PriorityQueue<Long> total = new PriorityQueue<>(Collections.reverseOrder());
        //무수히 많아지는 경우 확인 Flag
        boolean fail_flag = true;
        //모든 컴퓨터 가능 수익 창출 확인
        for(int i=1;i<=N;i++) {
            //무수히 많은 금액 창출할 때
            if(!visited[i] && money[i] > 0){
                fail_flag = false;
                result = -1;
                break;
            }
            total.add(time[i] * money[i]);
        }
        //무수히 많은 금액 창출하지 않을 때
        //가장 높은 수익 X개 구해서 더하기
        if(fail_flag){
            for(int i=0;i<X;i++)
                result += total.poll();
        }
        //결과 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //보안 시스템 기준 BFS 탐색 진행하는 함수
    static  void bfs() {
        //BFS에 사용할 PriorityQueue
        PriorityQueue<Info> pq = new PriorityQueue<>();
        //초기 보안 컴퓨터 설치
        for (int i = 0; i < Y; i++) {
            int secIdx = secureCom[i];
            pq.add(new Info(secIdx, 0));
            visited[secIdx] = true;
        }
        //BFS 탐색으로 회선으로 보안 시스템 확장
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            for (int nxt : graph.get(cur.idx)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    time[nxt] = cur.time + 1;
                    pq.add(new Info(nxt, time[nxt]));
                }
            }
        }
    }
}