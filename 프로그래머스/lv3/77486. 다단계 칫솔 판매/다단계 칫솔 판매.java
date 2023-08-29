import java.util.*;
class Solution {
    class Salesman{
        String name;
        Salesman recommender;
        int money;
        
        Salesman(String name,Salesman recommender,int money){
            this.name = name;
            this.recommender = recommender;
            this.money = money;
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String,Salesman> map = new HashMap<>();
        for(int i=0;i<enroll.length;i++){
            if(referral[i].equals("-")){
                map.put(enroll[i],new Salesman(enroll[i],null,0));
            }else{
                map.put(enroll[i],new Salesman(enroll[i],map.get(referral[i]),0));
            }
        }
        for(int i=0;i<seller.length;i++){
            Salesman salesman = map.get(seller[i]);
            int money = amount[i] * 100;
            while(salesman!=null){
                int pareMoney = money / 10 * 9 + money%10;
                int remainMoney = money / 10;
                if(remainMoney==0){
                    salesman.money += money;
                    break;
                }
                money = remainMoney;
                salesman.money +=pareMoney;
                salesman = salesman.recommender;
            }
        }
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            Salesman salesman = map.get(enroll[i]);
            answer[i] = salesman.money;
        }
        return answer;
    }
}