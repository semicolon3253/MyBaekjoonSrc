import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
         * 노트북 n대를 생산하는데 지출은 A + (B * n)
         * 노트북 n대를 생산하는데 수익은 C * n
         * 
         * 지출과 수익이 같아 지려면 A + (B * n) = C * n 이어야한다.
         * 즉 식을 정리하면 둘이 같아지는 지점 n은 n = A / (C - B) 이다.
         * 손익 분기점은 같아지는 지점보다 더 커야하므로 실제 구하는 지점은 n + 1 이다.
         * 
         * 또한 C - B > 0이어야 하므로 C <= B인 경우는 불가능 하므로 -1을 출력한다.
         */

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());  // 고정 비용
        int B = Integer.parseInt(stk.nextToken());  // 가변 비용
        int C = Integer.parseInt(stk.nextToken());  // 대당 수익

        if(C <= B){
            bw.write("-1");
        }else{
            bw.write(String.valueOf( A/(C-B) + 1 ));
        }

        bw.flush();
        br.close();
        bw.close();
    }

}