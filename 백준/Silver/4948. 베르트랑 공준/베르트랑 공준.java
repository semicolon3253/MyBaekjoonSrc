import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체를 만든다
        boolean[] prime_list = new boolean[246913];  // 인덱스에 해당하는 숫자가 소수면 false(기본값)으로 둔다. 또한 0부터 시작하므로 길이는 1을 더해준다
        prime_list[0] = true;  // 0과 1은 소수가 아니다
        prime_list[1] = true;

        // 최대 범위인 1000의 제곱근 이하를 조건으로
        for(int i=2; i<=Math.sqrt(246912); i++) {  // 위에서 0과 1을 처리했으므로 2부터 루프를 시작한다
            if(prime_list[i] == true){
                continue;  // 이전에 소수가 아님이 판별된 경우는 패스. ex) 4의 경우 2의 배수에서 이미 걸려졌다
            }

            for(int j=i*i; j<246913; j+=i) {
                prime_list[j] = true;  // j의 배수에 해당하는 수는 소수가 아닌것으로 처리한다
            }
        }

        int n= Integer.parseInt(br.readLine());  // 먼저 입력받는다
        int count;  // 개수를 저장할 변수
        while(n>0){  // 입력값이 0초과이면 계속 반복
            count = 0;  // 개수를 0으로 초기화

            for(int i=n+1; i<=2*n; i++){  // 개수를 구해야할 소수 X의 범위는 n<X<=2n 이므로 시작은 n+1이다
                if(prime_list[i] == false){  // 소수이면 개수 +1
                    count++;
                }
            }
            bw.write(count + "\n");
            bw.flush();

            n = Integer.parseInt(br.readLine());
        }

        bw.flush();
        br.close();
        bw.close();
    }

}