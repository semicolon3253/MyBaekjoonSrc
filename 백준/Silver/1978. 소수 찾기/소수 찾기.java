import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        br.readLine();  // N은 필요없음
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 에라토스테네스의 체를 만든다
        boolean[] prime_list = new boolean[1001];  // 인덱스에 해당하는 숫자가 소수면 false(기본값)으로 둔다. 또한 0부터 시작하므로 길이는 1을 더해준다
        prime_list[0] = true;  // 0과 1은 소수가 아니다
        prime_list[1] = true;

        // 최대 범위인 1000의 제곱근 이하를 조건으로
        for(int i=2; i<=Math.sqrt(1000); i++) {  // 위에서 0과 1을 처리했으므로 2부터 루프를 시작한다
            if(prime_list[i] == true){
                continue;  // 이전에 소수가 아님이 판별된 경우는 패스. ex) 4의 경우 2의 배수에서 이미 걸려졌다
            }

            for(int j=i*i; j<1001; j+=i) {
                prime_list[j] = true;  // j의 배수에 해당하는 수는 소수가 아닌것으로 처리한다
            }
        }

        while(stk.hasMoreTokens()){
            int n = Integer.parseInt(stk.nextToken());
            if(prime_list[n] == false){  // 에라토스테네스의 체에서 소수인지 아닌지 확인 후 맞으면 개수를 +1한다
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }

}