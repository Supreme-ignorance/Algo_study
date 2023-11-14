function solution(maps) {
    
    const dr = [-1, 0, 1, 0];
    const dc = [0, -1, 0, 1];
    
    const ROW = maps.length;
    const COL = maps[0].length;
    
    let visited = Array(ROW).fill().map(e => Array(COL).fill(false));
    
    const bfs = ((r, c) => {
        let q = new Array();
        q.push([r, c]);
        visited[r][c] = true;
        let count = 1;
        
        while(q.length !== 0) {
            const size = q.length;
            for (let i = 0; i < size; i++) {
                let current = q.shift();
                // console.log(current);
                
                if (current[0] == ROW - 1 && current[1] == COL - 1) {
                    return count;
                }
                
                for (let d = 0; d < 4; d++) {
                    let nextRow = current[0] + dr[d];
                    let nextCol = current[1] + dc[d];

                    if (nextRow < 0 || ROW <= nextRow 
                        || nextCol < 0 || COL <= nextCol) continue;

                    if (!visited[nextRow][nextCol] && maps[nextRow][nextCol] == 1) {
                        q.push([nextRow, nextCol]);
                        visited[nextRow][nextCol] = true; 
                    }
                }
            }
            count++;
        }
        return -1;
    })
    
    const result = bfs(0, 0, visited, maps, dr, dc, ROW, COL);
    var answer = result;
    return answer;
}