class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        String[] playTime = play_time.split(":");
        int p = Integer.parseInt(playTime[0]) * 60 * 60;
        p += Integer.parseInt(playTime[1]) * 60;
        p += Integer.parseInt(playTime[2]);
        
        String[] advTime = adv_time.split(":");
        int a = Integer.parseInt(advTime[0]) * 60 * 60;
        a += Integer.parseInt(advTime[1]) * 60;
        a += Integer.parseInt(advTime[2]);
        
        // System.out.println(a);
        
        if (p == a) {
            return "00:00:00";
        }
        
        int[] record = new int[p];
        for (String log : logs) {
            String[] start_end = log.split("-");
            String[] start = start_end[0].split(":");
            String[] end = start_end[1].split(":");
            
            int s = Integer.parseInt(start[0]) * 60 * 60;
            s += Integer.parseInt(start[1]) * 60;
            s += Integer.parseInt(start[2]);
            
            int e = Integer.parseInt(end[0]) * 60 * 60;
            e += Integer.parseInt(end[1]) * 60;
            e += Integer.parseInt(end[2]);
            
            for (int i = s; i < e; i++) {
                record[i]++;
            }
        }
        
        long sum = 0;
        for (int i = 0; i < a; i++) {
            sum += record[i];
        }
        
        long max = sum;
        long maxStartIndex = 0;
        
        for (int i = a; i < p; i++) {
            sum += record[i];
            sum -= record[i - a];
            
            if (max < sum) {
                max = sum;
                maxStartIndex = i - a + 1;
            }
        }
        
        long hour = maxStartIndex / 3600;
        long minute = maxStartIndex % 3600 / 60;
        long second = maxStartIndex % 3600 % 60;
        
        System.out.println(hour + ":" + minute + ":" + second);
        
        String answer = "";
        if (hour < 10) {
            answer += "0";
            answer += hour;
        }
        else {
            answer += hour;
        }
        answer += ":";
        
        if (minute < 10) {
            answer += "0";
            answer += minute;
        }
        else {
            answer += minute;
        }
        answer += ":";
        
        if (second < 10) {
            answer += "0";
            answer += second;
        }
        else {
            answer += second;
        }
        
        return answer;
    }
}