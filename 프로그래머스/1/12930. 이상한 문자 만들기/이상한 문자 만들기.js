function solution(s) {
    var answer = '';
    strs = s.split(' ');
    let size = strs.length;
    strs.forEach((str,i)=>{
        strArr = str.split('');
        strArr.forEach((s,j)=>{
            if(j%2==0){
                strArr[j] = s.toUpperCase();
            }else{
                strArr[j] = s.toLowerCase();
            }
        });
        answer+=strArr.join('');
        if(i<size-1){
            answer+=' ';
        }
    })
    
    return answer;
}