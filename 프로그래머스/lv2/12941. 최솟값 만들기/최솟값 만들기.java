
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int ans = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        while (!a.isEmpty()) {
            ans += a.remove() * b.remove();
        }

        return ans;     
    }
}