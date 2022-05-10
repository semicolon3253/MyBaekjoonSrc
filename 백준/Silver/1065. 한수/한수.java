import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // N 값을 읽는다
        int count = 0;  // 한수의 개수를 저장한다
        for(int i=1; i<=N; i++){  // 1 <= i <= N
            if(isHan(i)){ 
                count++;  // 한수라면 +1
            }
        }
        bw.write(String.valueOf(count));  // 한수의 개수 출력

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean isHan(int num){  // 한수를 판별하는 함수다
        int num_length = String.valueOf(num).length();  // 입력받은 수의 자리수를 구한다

        if(num_length == 1){  // 만약 한자리 수라면 무조건 한수이므로 true 리턴
            return true;
        }

        int[] digit_arr = new int[num_length];  // 각 자리를 차례대로 저장할 배열 ex) 123 => [1,2,3]
        int idx = 0;  // digit_arr의 인덱스로 쓸 변수
        for(int i=num_length; i>0; i--){  // 큰자리의 수부터 추출하기 위해서 내림차순으로 간다
            int power = (int) Math.pow(10, i-1);  // 나눌 수를 구한다. 10의 i-1승.
            int digit = num / power;  // 자리수를 구한다.  123 / (10^2) = 1.xxx로 몫 부분이 구할 자리수이다 
            digit_arr[idx] = digit;  //구한 자리수 저장
            num %= power;  // 높은 쪽의 자리수를 구했으므로 해당 자리는 제외. 위의 주석 기준 xxx부분을 정수로 저장
            idx++;  // digit_arr 인덱스 증가
        }

        // 첫번째 수의 차이를 구한다.
        // 한자리 수의 경우 벌써 위에서 판별했으므로 인덱스 1에의해 범위초과 예외는 발생하지 않는다.
        int first_dif = digit_arr[1] - digit_arr[0];
        for(int i=0; i<num_length - 1; i++){
            if(digit_arr[i+1] - digit_arr[i] != first_dif){  // 그다음 반복문으로 2,3 자리의 차... 3,4자리의 차...를 구한다.
                return false;  // 등차수열의 차가 항상 같아야 하므로 차가 다르게 나오면 한수가 아니다
            }
        }
        return true;  // 모두 차가 같으면 한수다
    }
}