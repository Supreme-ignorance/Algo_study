import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int minP;
    static int minF;
    static int minS;
    static int minV;
    static Food[] foods;

    static String result = "";
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        minP = kb.nextInt();
        minF = kb.nextInt();
        minS = kb.nextInt();
        minV = kb.nextInt();

        foods = new Food[N];
        for (int i = 0; i < N; i++) {
            foods[i] = new Food(i + 1, kb.nextInt(), kb.nextInt(), kb.nextInt(), kb.nextInt(), kb.nextInt());
        }

        recur(0, new ArrayList<>());

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        System.out.println(result);
    }

    static void recur(int cnt, List<Food> candidate) {
        if (cnt == N) {
            int sumP = 0;
            int sumF = 0;
            int sumS = 0;
            int sumV = 0;
            int sumC = 0;
            for (Food food : candidate) {
                sumP += food.p;
                sumF += food.f;
                sumS += food.s;
                sumV += food.v;
                sumC += food.c;
            }
            if (sumP >= minP && sumF >= minF && sumS >= minS && sumV >= minV) {
                String str = "";
                for (Food food : candidate) {
                    str += food.number + " ";
                }

                if (sumC < min) {
                    min = sumC;
                    result = str;
                }
                if (sumC == min) {
                    String[] arr = new String[2];
                    arr[0] = result;
                    arr[1] = str;
                    Arrays.sort(arr);
                    result = arr[0];
                }
            }
            return;
        }

        // 이번 음식 선택하기
        List<Food> newList = new ArrayList<>(candidate);
        newList.add(foods[cnt]);
        recur(cnt + 1, newList);

        // 이번 음식 선택안하기
        recur(cnt + 1, candidate);
    }

    static class Food {
        int number;
        int p;
        int f;
        int s;
        int v;
        int c;

        public Food(int number, int p, int f, int s, int v, int c) {
            this.number = number;
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }
}
