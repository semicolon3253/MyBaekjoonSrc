import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = factorial(N);
        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();
    }

    static int factorial(int n){
        if(n <= 1) return 1;  // 조건이 n==1이라면 0이 입력됐을때 걸러지지 않아 StackOverflow가 발생한다
        return n * factorial(n-1);
    }

}