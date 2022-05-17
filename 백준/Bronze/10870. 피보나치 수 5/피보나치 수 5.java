import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fibonacci(n)));

        bw.flush();
        br.close();
        bw.close();
    }

    static int fibonacci(int num){
        if(num == 0 || num == 1){  // 입력이 0이나 1일때는 그대로 반환한다
            return num;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);  // 문제에 나온 식 이용:  F(n) = F(n-1) + F(n-2)
    }

}