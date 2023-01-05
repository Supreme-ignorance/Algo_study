import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int M = kb.nextInt(); //배열의 크기 수

        int[] rows = new int[M];
        int[] columns = new int[M - 1];

        int day = kb.nextInt(); //날짜
        for (int i = 0; i < day; i++) { //날짜 개수만큼 반복

            int[] growthList = new int[3]; // 수열의 리스트
            for (int j = 0; j < 3; j++) {
                growthList[j] = kb.nextInt();
            }

            for (int j = 0; j < M; j++) { // 왼쪽 아래부터 왼쪽 위까지
                rows[j] += getGrowthFromList(growthList);
            }

            for (int j = 0; j < columns.length; j++) {
                columns[j] += getGrowthFromList(growthList);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = M - 1; i >= 0; i--) {
            stringBuilder.append((rows[i] + 1) + " ");
            for (int j = 0; j < columns.length; j++) {
                stringBuilder.append((columns[j] + 1) + " ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    } //main

    static int getGrowthFromList(int[] growthList) {
        if (growthList[0] != 0) {
            growthList[0]--;
            return 0;
        }
        else if (growthList[1] != 0) {
            growthList[1]--;
            return 1;
        }
        else {
            growthList[2]--;
            return 2;
        }
    }
}