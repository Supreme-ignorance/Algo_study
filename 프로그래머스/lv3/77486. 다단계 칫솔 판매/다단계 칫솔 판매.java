import java.util.*;

class Solution {
    static class Member {
        int idx = 0;
        int total = 0;
        int earn = 0;
        int afterTax = 0;
        int tax = 0;
        String bossName;
        
        // public Member(String name) {
        //     this.name = name;
        // }
        
        public void getMoney(int earn) {
            this.earn = earn;
            this.tax = this.earn / 10;
            if (this.tax < 1) {
                this.afterTax = this.earn;
            } else {
                this.afterTax = this.earn - this.tax;
            }
            this.total += this.afterTax;
        }
    }
    
    static Map<String, Member> connection;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        connection = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String bossName = referral[i];
            
            Member member = new Member();
            member.bossName = bossName;
            member.idx = i;
            
            connection.put(name, member);
        }
        
        int N = seller.length;
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < N; i++) {
            String sellerName = seller[i];
            int earn = amount[i] * 100;
            
            while (!sellerName.equals("-")) {
                Member curr = connection.get(sellerName);
                curr.getMoney(earn);
                answer[curr.idx] = curr.total;
                if (curr.tax == 0) {
                    break;
                }
                earn = curr.tax;
                sellerName = curr.bossName;
            }
            
        }
        
        
        // for (int i = 0; i < answer.length; i++) {
        //     String name = enroll[i];
        //     int total = connection.get(name).total;
        //     answer[i] = total;
        // }
        return answer;
    }
}