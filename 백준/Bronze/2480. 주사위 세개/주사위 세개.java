import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());
        int n3 = Integer.parseInt(stk.nextToken());

        int result = 0;

        if(n1 == n2 && n2 == n3){  // 모두 같다
            result = 10000 + n1 * 1000;
        }else if(n1 == n2 || n1 == n3){  // 두개 같다
            result = 1000 + n1 * 100;
        }else if(n2 == n3){  // 두개 같다
            result = 1000 + n2 * 100;
        }else{  // 모두 다르다
            int max = Math.max(n1, Math.max(n2, n3));
            result = max * 100;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();
    }
}