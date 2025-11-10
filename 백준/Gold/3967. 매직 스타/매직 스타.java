import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int LIMIT = 12;
    static List<Integer> arr = new ArrayList<>();
    static boolean[] candidates = new boolean[12 + 1];

    static int[][] locations = {
            {0, 2, 5, 7},
            {0, 3, 6, 10},
            {1, 2, 3, 4},
            {7, 8, 9, 10},
            {1, 5, 8, 11},
            {4, 6, 9, 11}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int size = 0; size < 5; size++) {
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != '.') {
                    if (line.charAt(i) == 'x') {
                        arr.add(0);
                    }
                    else {
                        arr.add(line.charAt(i) - 'A' + 1);
                    }
                }
            }
        }

        // 이용했던 것 방문 처리
        for (int i = 0; i < arr.size(); i++) {
            candidates[arr.get(i)] = true;
        }
        recur(0);
    }

    static void recur(int cur) {
        if (cur == LIMIT) {
            for (int i = 0; i < locations.length; i++) {
                int sum = 0;
                for (int j = 0; j < locations[i].length; j++) {
                    sum += arr.get(locations[i][j]);
                    if (sum > 26) {
                        return;
                    }
                }
            }

            List<Character> result = arr.stream()
                    .map(i -> (char) (i + 'A' - 1))
                    .collect(Collectors.toList());
            
            System.out.println("...." + result.get(0) + "....");
            System.out.println("." + result.get(1) + "." + result.get(2) + "." + result.get(3) + "." + result.get(4) + ".");
            System.out.println(".." + result.get(5) + "..." + result.get(6) + "..");
            System.out.println("." + result.get(7) + "." + result.get(8) + "." + result.get(9) + "." + result.get(10) + ".");
            System.out.println("...." + result.get(11) + "....");
            System.exit(0);
        }

        if (arr.get(cur) != 0) {
            recur(cur + 1);
            return;
        }

        for (int i = 1; i <= 12; i++) {
            if (candidates[i]) {
                continue;
            }

            arr.set(cur, i);
            candidates[i] = true;
            recur(cur + 1);
            arr.set(cur, 0);
            candidates[i] = false;
        }
    }
}
