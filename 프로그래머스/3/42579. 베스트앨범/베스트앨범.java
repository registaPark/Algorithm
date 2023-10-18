import java.util.*;
class Solution {
    class Song{
            int idx;
            int play;
            public Song(int idx,int play){
                this.idx = idx;
                this.play = play;
            }
        }
    class Value{
        int count;
        PriorityQueue<Song> pq = new PriorityQueue<>((s1,s2)->{
            if(s1.play==s2.play){
                return s1.idx-s2.idx;
            }return s2.play-s1.play;
        });
        public Value(int count){
            this.count = count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Value> map = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(map.containsKey(genres[i])){
                Value v = map.get(genres[i]);
                v.pq.add(new Song(i,plays[i]));
                v.count+=plays[i];
            }else{
                map.put(genres[i],new Value(plays[i]));
                map.get(genres[i]).pq.add(new Song(i,plays[i]));
            }
        }
        List<Map.Entry<String,Value>> list = new ArrayList<>(map.entrySet());
        list.sort((e1,e2)->e2.getValue().count-e1.getValue().count);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int genreCount = 0;
            while(!list.get(i).getValue().pq.isEmpty()){
                if(genreCount==2) break;
                answer.add(list.get(i).getValue().pq.poll().idx);
                genreCount++;
            }
        }
        int[] ans = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}