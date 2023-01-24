import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String p = br.readLine();

        int answer = 0;
        int start = 0;
        int end = 2;

        if(p.length()==1){
            System.out.println(1);
            return;
        }
        while(true){
            if(s.contains(p.substring(start, end))){
                end++;
                if (end == p.length()+1){
                    answer++;
                    break;
                }
                continue;
            }
            answer++;
            start = end -1;
            end = start + 2;
            if(start == p.length()-1){
                answer++;
                break;
            }
        }

        System.out.println(answer);

    }

}