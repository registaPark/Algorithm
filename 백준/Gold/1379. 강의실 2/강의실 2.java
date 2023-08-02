import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture>{
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.start-o.start;
        }
    }
    static class Room implements Comparable<Room>{
        int endTime;
        int number;

        public Room(int endTime, int number) {
            this.endTime = endTime;
            this.number = number;
        }

        @Override
        public int compareTo(Room o) {
            return this.endTime-o.endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        PriorityQueue<Integer> canPickRoom = new PriorityQueue<>();
        int cnt=0;
        int[] lectureRoomNum = new int[n + 1];
        for(int i=0;i<n;i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lectures.add(new Lecture(arr[0],arr[1],arr[2]));
        }
        for(int i=0;i<n;i++){
            Lecture lecture = lectures.poll();
            while (!rooms.isEmpty() && rooms.peek().endTime <= lecture.start)
                canPickRoom.add(rooms.poll().number);

            if(!canPickRoom.isEmpty()){
                Integer roomNum = canPickRoom.poll();
                lectureRoomNum[lecture.num] = roomNum;
                rooms.add(new Room(lecture.end, roomNum));
            }else{
                lectureRoomNum[lecture.num] = rooms.size()+1;
                cnt++;
                rooms.add(new Room(lecture.end, rooms.size()+1));
            }
        }
        System.out.println(cnt);
        for(int i=1;i<=n;i++){
            System.out.println(lectureRoomNum[i]);
        }

    }
}
