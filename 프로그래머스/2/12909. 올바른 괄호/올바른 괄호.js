function solution(s){
    
    const arr = [];
    
    var answer = true;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    for (i = 0; i < s.length; i++) {
        let cur = s.charAt(i);
        if (cur === ')') {
            if (arr[arr.length - 1] === '(') {
                arr.pop();
            }
            else {
                return false;
            }
        }
        if (cur === '(') {
            arr.push(cur);
        }
    }
    if (arr.length > 0) return false;
    
    return answer;
}