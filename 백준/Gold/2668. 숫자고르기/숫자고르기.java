import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i = 1; i <= N; i++) {
//            visited = new boolean[N + 1];
//            visited[i] = true;
            dfs(i, new ArrayList<>(), new ArrayList<>(), i);
        }
        System.out.println(count);
        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    static void dfs(int curIdx, List<Integer> idxs, List<Integer> results, int start) {
        int nextIdx = arr[curIdx];
        idxs.add(curIdx);
        results.add(nextIdx);

        if (idxs.contains(nextIdx)) {
            Collections.sort(idxs);
            Collections.sort(results);

            boolean flag = true;
            for (int i = 0; i < idxs.size(); i++) {
                if (idxs.get(i) != results.get(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                answers.add(start);
            }

        }
        else {
            dfs(nextIdx, idxs, results, start);
        }
    }
}
