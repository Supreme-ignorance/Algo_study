import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int testCase = kb.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            int countOfDay = kb.nextInt();
            long[] valueOfStocks = new long[countOfDay];

            for (int i = 0; i < countOfDay; i++) {
                valueOfStocks[i] = kb.nextInt();
            }

            long max = valueOfStocks[countOfDay - 1];
            long profit = 0;

            for (int i = countOfDay - 2; i >= 0; i--) {

                if (valueOfStocks[i] > max) {
                    max = valueOfStocks[i];
                }
                else {
                    profit += (max - valueOfStocks[i]);
                }
            }

            System.out.println(profit);

        }//testCase
    }//main
}