import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체를 만든다
        boolean[] prime_list = new boolean[10001];  // 인덱스에 해당하는 숫자가 소수면 false(기본값)으로 둔다. 또한 0부터 시작하므로 길이는 1을 더해준다
        prime_list[0] = true;  // 0과 1은 소수가 아니다
        prime_list[1] = true;

        // 최대 범위인 1000의 제곱근 이하를 조건으로
        for(int i=2; i<=Math.sqrt(10000); i++) {  // 위에서 0과 1을 처리했으므로 2부터 루프를 시작한다
            if(prime_list[i] == true){
                continue;  // 이전에 소수가 아님이 판별된 경우는 패스. ex) 4의 경우 2의 배수에서 이미 걸려졌다
            }

            for(int j=i*i; j<10001; j+=i) {
                prime_list[j] = true;  // j의 배수에 해당하는 수는 소수가 아닌것으로 처리한다
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int tmp=0; tmp<T; tmp++){  // 테스트 케이스만큼 반복
            int n = Integer.parseInt(br.readLine());  // 숫자를 입력받는다
            int half_n = n / 2;  // 그것을 반으로 나눈다. 입력은 짝수이므로 무조건 나누어 떨어진다
            int another = n - half_n;  // 원래 n에서 반으로 나눈것을 뺀다

            while(true){  // 계속 반복
                if(prime_list[half_n] == false && prime_list[another] == false){  // 저 두 수가 모두 소수이면 출력후 종료한다
                    bw.write(half_n + " " + another + "\n");
                    bw.flush();
                    break;
                }

                half_n--;  // 아니면 half_n을 1씩 줄여나간다
                another = n - half_n;  // 나머지 숫자도 다시 전체에서 1줄인 half_n을 뺀다
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }

}