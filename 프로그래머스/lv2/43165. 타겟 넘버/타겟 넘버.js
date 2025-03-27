function solution(numbers, target) {
    
    let count = 0;
    const dfs = (here, sum) => {
        if (here == numbers.length) {
            if (sum == target) {
                count += 1;
            }
            return;
        }
        let plus = numbers[here];
        let minus = numbers[here] - (numbers[here] * 2);
        dfs(here + 1, sum + plus);
        dfs(here + 1, sum + minus);
        
    }
    dfs(0, 0);
    
    var answer = count;
    return answer;
}