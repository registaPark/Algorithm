import java.util.ArrayList;
class Solution {
    
    static class Hand{
        int y;
        int x;
        public Hand(int y ,int x){
            this.y = y;
            this.x = x;
        }
        
        public int getY(){
            return this.y;
        }
        public int getX(){
            return this.x;
        }
        public void setPosition(int y,int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static class Key{
        int y;
        int x;
        public Key(int y,int x){
            this.y = y;
            this.x = x;
        }
        public int getY(){
            return this.y;
        }
        public int getX(){
            return this.x;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Key> keys =  new ArrayList<>();
        keys.add(new Key(3,1));
        for(int i=0;i<=3;i++){
            for(int j=0;j<3;j++){
                Key k = new Key(i,j);
                keys.add(k);
            }
        }
        Hand leftHand = new Hand(3,0);
        Hand rightHand = new Hand(3,2);
        for(int i=0;i<numbers.length;i++){
            Key k = keys.get(numbers[i]);
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                leftHand.setPosition(k.getY(),k.getX());
                sb.append("L");
            }
            else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                rightHand.setPosition(k.getY(),k.getX());
                sb.append("R");
            }
            else{
                int leftDist = Math.abs(k.getY()-leftHand.getY())+Math.abs(k.getX()-leftHand.getX());
                int rightDist = Math.abs(k.getY()-rightHand.getY())+Math.abs(k.getX()-rightHand.getX());
                if(leftDist==rightDist){
                    if(hand.equals("right")){
                        sb.append("R");
                        rightHand.setPosition(k.getY(),k.getX());
                    }
                    else{
                         sb.append("L");
                        leftHand.setPosition(k.getY(),k.getX());
                    }
                }
                else if(leftDist>rightDist) {
                    sb.append("R");
                    rightHand.setPosition(k.getY(),k.getX());
                   }
                else if(leftDist<rightDist){
                    sb.append("L");
                    leftHand.setPosition(k.getY(),k.getX());
                } 
            }
        }
        return sb.toString();
    }
}