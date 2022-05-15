import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());

        int day = (V - B) / (A - B);  // 전체 높이에서 내려가는 길이를 빼서 완벽하게 한 사이클을 돌 수 있는 날수만 계산
        if((V - B) % (A - B) != 0){  // 남는 블록이 있다면 다음 날 올라가므로 1일을 더해준다
            day++;
        }

        bw.write(String.valueOf(day));

        bw.flush();
        br.close();
        bw.close();
    }

}