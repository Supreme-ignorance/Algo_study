class Solution {
    
    // int[][] map;
    int keySize;
    int lockSize;
    int mapSize;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        keySize = key.length;
        lockSize = lock.length;
        mapSize = lockSize + ((keySize - 1) * 2);
        
        // map = new int[mapSize][mapSize];
        // for (int i = 0; i < lockSize; i++) {
        //     for (int j = 0; j < lockSize; j++) {
        //         map[i + keySize - 1][j + keySize - 1] = lock[i][j]
        //     }
        // }
        
        // boolean isLocked = true;
        int dir = 0;
        while (dir < 4) { //아직 잠겼고, 0-90-180-270까지 다 안돌았다면
            for (int r = 0; r <= mapSize - keySize; r ++) {
                for (int c = 0; c <= mapSize - keySize; c++) {
                    int[][] temp = copy(lock);
                    addKey(r, c, dir, key, temp);
                    if (check(temp)) {
                        return true;
                    }
                }
            }
            dir++; //방향 업데이트
        }
        
        boolean answer = false;
        return answer;
    }
    
    private void addKey(int startRow, int startCol, int dir, int[][] key, int[][] temp) {
        if (dir == 0) {
            for (int r = 0; r < key.length; r++) {
                for (int c = 0; c < key.length; c++) {
                    temp[startRow + r][startCol + c] += key[r][c];
                }
            }
        }
        else if (dir == 1) { //90도
            for (int r = 0; r < key.length; r++) {
                for (int c = 0; c < key.length; c++) {
                    temp[startRow + r][startCol + c] += key[(key.length - 1) - c][r];
                }
            }
        }
        else if (dir == 2) { //180도
            for (int r = 0; r < key.length; r++) {
                for (int c = 0; c < key.length; c++) {
                    temp[startRow + r][startCol + c] += key[(key.length - 1) - r][(key.length - 1) - c];
                }
            }
        }
        else { //270도
            for (int r = 0; r < key.length; r++) {
                for (int c = 0; c < key.length; c++) {
                    temp[startRow + r][startCol + c] += key[c][(key.length - 1) - r];
                }
            }
        }
    }
    
    private int[][] copy(int[][] lock) {
        int[][] map = new int[mapSize][mapSize];
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                map[i + keySize - 1][j + keySize - 1] = lock[i][j];
            }
        }
        return map;
    }
    
    private boolean check(int[][] temp) {
        int checkCount = 0;
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (temp[i + keySize - 1][j + keySize - 1] == 1) {
                    checkCount++;
                }
            }
        }
        return checkCount == (lockSize * lockSize);
    }
}