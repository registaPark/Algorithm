function solution(lottos, win_nums) {
    let bestSituation = 0;
    let worstSituation = 0;
    lottos.forEach((num)=>{
        if(num===0){
            bestSituation++;
        }
        else if(win_nums.includes(num)){
            bestSituation++;
            worstSituation++;
        }
    });
    let bestRank = 7-bestSituation;
    let worstRank = 7-worstSituation;
    if(worstRank==7) worstRank--;
    if(bestRank==7) bestRank--;
    var answer = [bestRank,worstRank];
    return answer;
}