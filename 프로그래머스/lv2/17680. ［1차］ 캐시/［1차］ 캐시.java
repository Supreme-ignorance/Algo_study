import java.util.*;

class Solution {
    static class Refer implements Comparable<Refer> {
        String cityName;
        int referTime;
        
        public Refer(String cityName, int referTime) {
            this.cityName = cityName;
            this.referTime = referTime;
        }
        
        @Override
        public int compareTo(Refer o) {
            return this.referTime - o.referTime;
        }
    };
    static PriorityQueue<Refer> cache;
    static Map<String, Boolean> cacheCheck;
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        
        cache = new PriorityQueue<>();
        cacheCheck = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String currCity = cities[i].toLowerCase();
            
            // 캐시 hit
            if (cacheCheck.keySet().contains(currCity) && cacheCheck.get(currCity)) {
                time += 1;
                
                // 페이지 갱신
                Queue<Refer> temp = new ArrayDeque<>();
                while (!cache.isEmpty()) {
                    Refer currCache = cache.poll();
                    if (currCache.cityName.equals(currCity)) {
                        cache.add(new Refer(currCity, i));
                        break;
                    } else {
                        temp.add(currCache);
                    }
                }
                
                while (!temp.isEmpty()) {
                    cache.add(temp.poll());
                }
            }
            
            // 캐시 miss
            else if (!cacheCheck.keySet().contains(currCity) || !cacheCheck.get(currCity)) {
                time += 5;
                if (cacheSize == 0) continue;
                if (cache.size() == cacheSize) {
                    Refer out = cache.poll();
                    cacheCheck.put(out.cityName, false);
                }
                cacheCheck.put(currCity, true);
                cache.add(new Refer(currCity, i));
                
            }
        }
        
        return time;
    }
}