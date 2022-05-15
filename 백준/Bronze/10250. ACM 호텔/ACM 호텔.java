import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(stk.nextToken());
            stk.nextToken();  // W는 필요없음
            int N = Integer.parseInt(stk.nextToken());
            int x, y;

            if(N%H == 0){  // 꼭대기 방인 경우
                x = N / H;  // 나누어 떨어지므로 x는 N/H의 몫이다
                y = H * 100;  // 꼭대기 방이므로 층은 H 그대로이다
            }else{  // 나머지의 경우
                x = (N / H) + 1;  // 방 번호를 층 개수로 나눈 후 그 다음 줄에 찾는 방이 있으므로 +1
                y = (N % H) * 100;  // 층은 이렇게 구하고 최소 백의 자리부터 시작하므로 100을 곱한다
            }

            bw.write(String.valueOf(x+y));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}