import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> outTime = new HashMap<>();
        Map<String, Integer> resultTime = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            StringTokenizer token = new StringTokenizer(records[i]);
            String time = token.nextToken();
            String numbers = token.nextToken();
            String type = token.nextToken();
            
            String[] times = time.split(":");
            int hour = Integer.valueOf(times[0]);
            int minute = Integer.valueOf(times[1]);
            int result = (hour * 60) + minute;
            if (type.equals("IN")) {
                inTime.put(numbers, result);
            }
            else {
                int startTime = inTime.get(numbers);
                result = result - startTime;
                inTime.remove(numbers);
                resultTime.put(numbers, 
                               resultTime.getOrDefault(numbers, 0) + result);
            }
        }
        
        for (String number : inTime.keySet()) {
            int startTime = inTime.get(number);
            int result = ((23 * 60) + 59) - startTime;
            resultTime.put(number, 
                           resultTime.getOrDefault(number, 0) + result);
        }
        
        
        List<Car> cars = new ArrayList<>();
        for (String key : resultTime.keySet()) {
            int time = resultTime.get(key);
            int overTime = 0;
            if (time - defaultTime > 0) { // 기본시간을 초과했을 때
                overTime = ((time - defaultTime) / unitTime);
                int temp = ((time - defaultTime) % unitTime) == 0 ? 0 : 1;
                overTime += temp;
            }

            int finalFee = defaultFee + (overTime * unitFee);
            
            // System.out.println("overTime : " + overTime + " " + "finalFee: " + finalFee);
            
            cars.add(new Car(key, finalFee));
        }
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.numbers.compareTo(car2.numbers);
            }
        });
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            answer[i] = car.fee;
        }
        
        return answer;
    }
    
    class Car {
        String numbers;
        int fee;
        
        Car(String numbers, int fee) {
            this.numbers = numbers;
            this.fee = fee;
        }
        @Override
        public String toString() {
            return numbers + " " + fee;
        }
    }
}