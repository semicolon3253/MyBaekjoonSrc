import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(stk.nextToken());  // 각 숫자를 입력받는다
        int num2 = Integer.parseInt(stk.nextToken());

        int r1 = reverseNum(num1);  // 각 숫자를 뒤집는다
        int r2 = reverseNum(num2);
        if(r1 > r2){  // 비교후 출력
            bw.write(String.valueOf(r1));
        }else{
            bw.write(String.valueOf(r2));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int LENGTH = 3;  // 입력되는 숫자의 자리수는 세자리 고정이므로 상수로 지정
    static int reverseNum(int num){  // 숫자를 뒤집는 함수
        int result = 0;  // 뒤집어진 숫자를 저장하는 변수

        int i = 1;  // M의 10의 차수를 구할 때 사용
        while(num>0){  // 수를 뒤집기 위해 일의자리 부터 한자리씩 때어낸다
            double N = Math.pow(10, LENGTH-i);  // 때어낼 숫자가 뒤집어진 숫자에서의 자리수. ex) 437에서 7을 때낼 때  N은 100
            result += num % 10 * N;  // num%10으로 오른쪽 자리수를 하나 때낸 다음 N을 곱해 뒤집어졌을 때 자리수로 만든다
            num /= 10;  // 위에서 때낸 수는 버리고 나머지 수로 정수를 만든다
            i++;
        }

        return result;
    }
}