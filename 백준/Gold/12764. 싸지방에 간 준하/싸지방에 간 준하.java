import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static class Index{
        int index;
        Person person;

        public Index(int index, Person person) {
            this.index = index;
            this.person = person;
        }
    }
    static class Person{
        int start;
        int end;

        public Person(int[] arr) {
            this.start = arr[0];
            this.end = arr[1];
        }
    }
    static int[] array = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Person> queue = new PriorityQueue<>((o1, o2) -> o1.start-o2.start);
        for(int i=0;i<n;i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.offer(new Person(arr));
        }
        Queue<Index> UsingComputers = new PriorityQueue<>((o1, o2) ->o1.person.end-o2.person.end);
        Queue<Integer> emptySeat = new PriorityQueue<>();
        int index=0;
        while (!queue.isEmpty()){
            Person person = queue.poll();
            if (UsingComputers.isEmpty()){
                UsingComputers.add(new Index(++index,person));
                array[index]++;
            }
            else{
                while (!UsingComputers.isEmpty()){
                    Index peek = UsingComputers.peek();
                    if(peek.person.end < person.start){
                        emptySeat.add(peek.index);
                        UsingComputers.poll();
                    }else break;
                }
                if(emptySeat.isEmpty()){
                    UsingComputers.add(new Index(++index,person));
                    array[index]++;
                }else{
                    Integer poll = emptySeat.poll();
                    array[poll]++;
                    UsingComputers.add(new Index(poll,person));

                }
            }
        }
        System.out.println(index);
        for(int i=1;i<=index;i++){
            System.out.print(array[i]+" ");
        }
    }
}
