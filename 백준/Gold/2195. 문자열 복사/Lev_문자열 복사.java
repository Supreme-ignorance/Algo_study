import java.util.Scanner;

public class Main {

    private static String originLine;
    private static String copyLine;

    private static int[] countOfSame;

    private static int result = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        originLine = kb.next();
        copyLine = kb.next();



        for (int i = 0; i < copyLine.length(); i++) {
            countOfSame = new int[originLine.length()];
            for(int j = 0; j < originLine.length(); j++) {
                if (originLine.charAt(j) == copyLine.charAt(i)) {
                    countOfSame[j]++;
                    int tempCopyIndex = i + 1;
                    int tempOriginIndex = j + 1;
                    while (checkNext(tempOriginIndex++, tempCopyIndex++)) {
                        countOfSame[j]++;
                    }
                }
            }
            i += (getMax(countOfSame) - 1); //기본적으로 i가 ++되기 때문에 -1을 해준다.
            result++;
        }

        System.out.println(result);

    }

    private static int getMax(int[] countOfSame) {
        int max = Integer.MIN_VALUE;
        for (int count : countOfSame) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    private static boolean checkNext(int originIndex, int copyIndex) {
        if (originIndex >= originLine.length()) {
            return false;
        }
        if (copyIndex >= copyLine.length()) {
            return false;
        }

        if (originLine.charAt(originIndex) == copyLine.charAt(copyIndex)) {
            return true;
        }
        return false;
    }
}