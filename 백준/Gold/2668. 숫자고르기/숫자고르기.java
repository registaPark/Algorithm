import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] board;
    static boolean[] check;
    static int num;
    static List<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        check = new boolean[n + 1];
        board = new int[n + 1];
        res = new ArrayList<Integer>();
        for(int i=1;i<n+1;i++){
            int k = Integer.parseInt(br.readLine());
            board[i]=k;
        }
        for(int i=1;i<n+1;i++){
            check[i]=true;
            num = i;
            dfs(i);
            check[i]=false;
        }
        res.stream().sorted();
        System.out.println(res.size());
        for (int a: res) {
            System.out.println(a);
        }
    }

    public static void dfs(int x){
        if(board[x]==num){
            res.add(num);
        }
        if(!check[board[x]]){
            check[board[x]] = true;
            dfs(board[x]);
            check[board[x]] = false;
        }
    }
}