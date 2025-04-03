import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 스탯이 1_000_000이니 3개면 1_000_000^3이다
 * 따라서 병사가 100이니까 이걸 활용하는 것 같았는데
 * 처음에는 병사들끼리 싸워서 자기포함 K명 이긴 애만 내가 이기면 되지 않을까
 * 생각했는데, 다들 어정쩡해서 서로 한명도 못 이기는
 * 10 5 5
 * 5 10 5
 * 5 5 10
 * 이 놈들이 문재였다.
 *
 * 그래서 답을 보니까, 병사들의 스탯을 돌면서 진수의 스탯을 만들어서
 * 병사들과 싸우게 하는 것이었다.
 * 병사들의 각 힘, 민첩, 지략을 완탐으로 돌면서
 * 진수의 스탯을 만들어주고
 * 그걸로 K명까지 이길 수 있다면, 가장 낮은 스탯 합을 측정하는 것이다.
 */

public class Main {
    static Enemy[] enemies;
    static List<Enemy> picked = new ArrayList<>();

    static int N;
    static int K;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        enemies = new Enemy[N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            enemies[i] = new Enemy(a, b, c);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 진수 스탯
                    int my_a = enemies[i].a;
                    int my_b = enemies[j].b;
                    int my_c = enemies[k].c;

                    int cnt = 0;
                    // 대결
                    for (int n = 0; n < N; n++) {
                        if (my_a >= enemies[n].a && my_b >= enemies[n].b && my_c >= enemies[n].c) {
                            cnt++;
                        }
                    }

                    if (cnt >= K) {
                        min = Math.min(min, my_a + my_b + my_c);
                    }
                }
            }
        }
        System.out.println(min);

    }


    static class Enemy {
        int a;
        int b;
        int c;

        public Enemy(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
