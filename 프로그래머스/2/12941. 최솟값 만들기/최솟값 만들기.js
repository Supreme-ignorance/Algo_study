function solution(A,B){
    const length = A.length;
        
    A.sort((a, b) => a - b);
    B.sort((a, b) => a - b);
    
    
    let sumF = 0;
    let sumS = 0;
    
    for (let i = 0; i < A.length; i++) {
        sumF += A[i] * B[length - 1 - i];
        sumS += B[i] * A[length - 1 - i];
    }
    return Math.min(sumF, sumS);   
}