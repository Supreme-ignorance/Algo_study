function solution(n, computers) {
    
    let a = Array(n).fill(0);
    
    
    const dfs = (index, visited) => {
        if (visited[index] != 0) return; //방문했으면 방문 X
        visited[index] = 1;
        computers[index].forEach((e, i) => {
            if (e == 1) {
                dfs(i, visited);
            }
        });
    }
    
    let count = 0;
    for (let i = 0; i < n; i++) {
        if (a[i] == 0) {
            dfs(i, a)
            count++;
        }
    }
    // console.log(count);
    var answer = count;
    return answer;
}