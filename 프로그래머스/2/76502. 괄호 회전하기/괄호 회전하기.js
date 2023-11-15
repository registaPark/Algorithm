function solution(s) {
    var size = s.length;
    var strArr = s.split('');
    var answer = 0;
    for(let i=0;i<size;i++){
        if(i!=0){
            strArr.push(strArr.shift());
        }
        var tmpArr = [];
        for(let j=0;j<size;j++){
            if(strArr[j]==')' && tmpArr[tmpArr.length-1]=='('){
                tmpArr.pop();    
            }
            else if(strArr[j]==']' && tmpArr[tmpArr.length-1]=='['){
                tmpArr.pop();
            }
            else if(strArr[j]=='}' && tmpArr[tmpArr.length-1]=='{'){
                tmpArr.pop();
            }else{
                tmpArr.push(strArr[j]);
            }
            }
        if(tmpArr.length==0){
            answer++;
        }
        }
    return answer;
    }