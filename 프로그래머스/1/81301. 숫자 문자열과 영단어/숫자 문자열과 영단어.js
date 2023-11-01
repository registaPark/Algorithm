function solution(s) {
    let dic = {};
    dic["zero"] = 0;dic["one"] = 1;dic["two"] = 2;dic["three"] = 3;dic["four"] = 4;dic["five"] = 5;dic["six"] = 6;dic["seven"] = 7;dic["eight"] = 8;dic["nine"] = 9;
    let str = "";
    let num = "";
    for(let i=0;i<s.length;i++){
        if(isNaN(s[i])){
            num+=s[i];
            if(num.length>=3 && num in dic){
                    str+=dic[num];
                    num='';
                }
            }else{
            str+=s[i];
        }
    }
    console.log(str);
    return parseInt(str);
}