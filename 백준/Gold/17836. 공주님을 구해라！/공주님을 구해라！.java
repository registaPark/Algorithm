import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Prince {
        int y;
        int x;
        int time;
        boolean sword = false;

        public Prince(int y, int x, int time, boolean sword) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.sword = sword;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N;
    static int M;
    static int T;
    static int[][] board;
    static boolean[][][] visited;
    static Queue<Prince> queue;
    static boolean rescue_princess = false;
    static int rescue_princess_min_time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr[0];
        M = arr[1];
        T = arr[2];
        visited = new boolean[N][M][2];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        queue = new LinkedList<>();
        queue.add(new Prince(0, 0, 0, false));
        while (!queue.isEmpty()) {
            Prince prince = queue.poll();
            if(prince.y==N-1 && prince.x==M-1 && prince.time<=T){
                rescue_princess_min_time = Math.min(rescue_princess_min_time,prince.time);
            }
            else if(prince.time<T){
                check_block(prince);
            }
        }
        if(rescue_princess_min_time>T) System.out.println("Fail");
        else System.out.println(rescue_princess_min_time);
    }

    public static void check_block(Prince prince) {
        if (prince.sword) {
            for (int i = 0; i < 4; i++) {
                int yy = prince.y + dy[i];
                int xx = prince.x + dx[i];
                if (0 <= yy && yy < N && 0 <= xx && xx < M && !visited[yy][xx][1]) {
                    queue.add(new Prince(yy, xx, prince.time + 1, true));
                    visited[yy][xx][1] = true;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int yy = prince.y + dy[i];
                int xx = prince.x + dx[i];
                if (0 <= yy && yy < N && 0 <= xx && xx < M && board[yy][xx] != 1 && !visited[yy][xx][0]) {
                    visited[yy][xx][0] = true;
                    if (board[yy][xx] == 2) {
                        queue.add(new Prince(yy, xx, prince.time + 1, true));
                    } else {
                        queue.add(new Prince(yy, xx, prince.time + 1, false));
                    }
                }
            }
        }
    }
}
