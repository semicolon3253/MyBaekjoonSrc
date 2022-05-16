import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0, min = -1;  // 각각 범위내의 소수의 합과 최솟값을 담을 변수
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

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

        for(int i=M; i<=N; i++){  // M이상 N이하의 범위에서 반복
            if(prime_list[i] == false){  // 에라토스테네스의 체에서 소수로 판별되면
                if(sum == 0){  // sum이 0이면 범위내의 첫번째 소수이므로 최솟값에 현재 소수 저장
                    min = i;
                }
                sum += i;  // 현재 소수를 누적해서 더함
            }
        }

        if(sum == 0){  // sum이 아직도 0이면 범위내에 소수가 한번도 없었다는 뜻이므로 -1 출력
            bw.write("-1");
        }else{  // 아니면 누적합과 최솟값 출력
            bw.write(String.valueOf(sum));
            bw.write("\n");
            bw.write(String.valueOf(min));
        }

        bw.flush();
        br.close();
        bw.close();
    }

}