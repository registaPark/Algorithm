import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] pages = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pages[i+1] = Integer.parseInt(st.nextToken());

        int currentPage = 0;
        int cacheSize = 0;
        Deque<Integer> frontCache = new ArrayDeque<>();
        Deque<Integer> backCache = new ArrayDeque<>();


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "B":
                    if(!backCache.isEmpty()) {
                        frontCache.addFirst(currentPage);
                        currentPage = backCache.pollLast();
                    }
                    break;
                case "F":
                    if(!frontCache.isEmpty()){
                        backCache.addLast(currentPage);
                        currentPage = frontCache.pollFirst();
                    }
                    break;
                case "A":
                    while(!frontCache.isEmpty())
                        cacheSize -= pages[frontCache.poll()];

                    if(currentPage != 0) backCache.addLast(currentPage);
                    currentPage = Integer.parseInt(st.nextToken());
                    cacheSize +=  pages[currentPage];

                    while(cacheSize > c)
                        cacheSize -= pages[backCache.pollFirst()];
                    break;
                case "C":
                    int idx = -1;
                    int size = backCache.size();

                    for(int j = 0; j < size; j++){
                        int page = backCache.pollFirst();
                        if(idx == page)
                            cacheSize -= pages[page];
                        else backCache.addLast(page);
                        idx = page;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(currentPage).append("\n");

        if(backCache.isEmpty()) sb.append(-1);
        while(!backCache.isEmpty())
            sb.append(backCache.pollLast()).append(" ");
        sb.append("\n");

        if(frontCache.isEmpty()) sb.append(-1);
        while(!frontCache.isEmpty())
            sb.append(frontCache.pollFirst()).append(" ");

        System.out.print(sb);
    }
}