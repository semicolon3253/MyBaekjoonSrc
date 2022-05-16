import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=2; i<=N; i++){  // 2부터 N까지 루프
            while(N%i == 0){  // 현재 숫자에 대해서 나눴을 때 나누어 떨어지면 
                bw.write(i + "\n");  // 해당 숫자를 출력하고
                N /= i;  // N을 그 숫자로 나눈다
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}