import java.util.*;

class Solution {
    
    private int[] myScores;
    private int myPoint;
    private int yourPoint;
    private int max = -1;
    private int[] maxArray;
    private boolean atLeast = false;
    
    public int[] solution(int n, int[] info) {
        
        myScores = new int[11];
        maxArray = new int[11];
        getScore(n, info, 0);
        
        // System.out.println(max);
        // System.out.println(Arrays.toString(maxArray));
        
        if (max == 0 || max == -1) {
            return new int[] {-1};
        }
        
        int[] answer = maxArray;
        return answer;
    }
    
    private void getScore(int n, int[] info, int idx) {
        if (n == 0 || idx == 11) { //기저조건 n을 다 사용하거나, 끝까지 가게 되면
            myPoint = getMyPoint(info);
            if (myPoint > yourPoint) {//라이언이 이겼을 시
                if (myPoint - yourPoint >= max) {
                    if (myPoint - yourPoint == max) {//최대 차이가 같을 시
                        int[] target = checkArr(myScores, maxArray);
                        copy(target, maxArray);
                    }
                    else { //다를 시
                        max = myPoint - yourPoint;
                        copy(myScores, maxArray);
                    }
                    // System.out.println(Arrays.toString(myScores));
                }

            }
            return;
        }
        
        if (info[idx] != 0) { //어피치가 맞춘 곳이라면
            if (n - (info[idx] + 1) >= 0) {// + 1개를 더 할수 있다면
                myScores[idx] = info[idx] + 1;
                getScore(n - (info[idx] + 1), info, idx + 1);
            }
        }
        else { // 0, 즉 어피치가 맞추지 않았다면
            myScores[idx] = 1; //하나만 해도 점수를 얻음
            getScore(n - 1, info, idx + 1);
        }
        
        if (idx == 10) {//마지막이라면
            myScores[idx] = n;
            getScore(n - n, info, idx + 1);
        }
        
        myScores[idx] = 0;
        getScore(n, info, idx + 1);
    }
    
    private int getMyPoint(int[] info) {
        int myPoint = 0;
        yourPoint = 0;
        for (int i = 0; i < 11; i++) {
            if (myScores[i] > info[i]) {
                myPoint += (10 - i);
            }
            if (info[i] >= myScores[i]) {
                if (info[i] != 0) {//0이 아니면, 
                    yourPoint += (10 - i);
                }
            }
        }
        return myPoint;
    }
    
    private void copy(int[] before, int[] target) {
        for (int i = 0; i < before.length; i++) {
            target[i] = before[i];
        }
    }
    
    private int[] checkArr (int[]a, int[] b) {

        for(int i = a.length-1; i >=0 ; i--) {
            if(a[i] == b[i]) continue;
            if(a[i] < b[i]) return b;
            break;
        }

        return a;
    }
}