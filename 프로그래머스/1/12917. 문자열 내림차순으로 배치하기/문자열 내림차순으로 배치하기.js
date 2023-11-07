function solution(s) {
    let downArr = [];
    let upArr = [];
    let idx = 0;
    for(let i=0;i<s.length;i++){
        if(s[i] === s[i].toUpperCase()){
            upArr[idx] = s[i];
        }
        else{
            downArr[idx] = s[i];   
        }
        idx++;
    }
    downArr.sort((a,b)=>b.localeCompare(a));
    upArr.sort((a,b)=>b.localeCompare(a));
    let answer = '';
    downArr.forEach((a)=>answer+=a);
    upArr.forEach((a)=>answer+=a);
    return answer;
}