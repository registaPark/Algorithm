class Solution
{
    public int solution(int n, int a, int b)
    {
        a--;
        b--;
        int answer = 1;
        while(true){
            a=a/2;
            b=b/2;
            if(a==b) return answer;
            answer++;            
        }
    }
}