import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();
        int k=0;
        while(list.size()<m*(t+1)){
            ArrayList<Character> li = new ArrayList<Character>();
            int a =k;
            while(true){
                if(a%n==10) li.add('A');
                else if (a%n==11) li.add('B');
                else if (a%n==12) li.add('C');
                else if (a%n==13) li.add('D');
                else if (a%n==14) li.add('E');
                else if (a%n==15) li.add('F');
                else li.add(Integer.toString(a%n).charAt(0));
                a=a/n;
                if(a==0){
                    break;
                }
                }
             Collections.reverse(li);
            for(int i=0;i<li.size();i++){
                list.add(li.get(i));
            }
            k++;
            }
           for(int i=0;i<t;i++){
            answer.append(list.get(p+(m*i)-1));
        }
        return answer.toString();
        }   
    }