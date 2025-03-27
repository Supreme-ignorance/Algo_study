import java.util.Scanner;

public class Main {

    private static int N;

    private static int max = 0;

    private static Process[] processes;

    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        processes = new Process[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            processes[i] = new Process(kb.nextInt(), kb.nextInt());
        }
        get(0);
        System.out.println(max);
    }

    private static void get(int index) {
        //기저조건
        if (index >= N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += processes[i].pay;
                }
            }

            if (sum > max) {
                max = sum;
            }
            return;
        }

        if (index + processes[index].days <= N) {//만약에 index(날짜) + processes[index] (상담 날짜) , 당일까지 포함임
            visited[index] = true;
            get(index + processes[index].days);
        }
        visited[index] = false;
        get(index + 1);
    }



    private static class Process {
        int days;
        int pay;

        public Process(int days, int pay) {
            this.days = days;
            this.pay = pay;
        }
    }
}