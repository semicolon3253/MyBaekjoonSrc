import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;  // 생성자를 저장할 변수. 기본값은 0

        for(int i=1; i<N; i++){  // 1부터 N미만까지 계산해본다
            int sum = i;  // 먼저 합계 변수에 현재 i를 저장하고

            char[] digit_list = String.valueOf(i).toCharArray();  // 현재 i를 자리수로 쪼갠 다음
            for (char c : digit_list) {
                sum += c - 48;  // 각 자리수의 숫자를 sum에 더한다
            }

            if(sum == N){  // 더한 결과가 N과 같으면 i는 N의 생성자다
                result = i;  // 저장하고 루프 탈출
                break;
            }
        }

        bw.write(String.valueOf(result));  // 생성자를 찾았으면 생성자가, 못찾고 루프를 나왔다면 기본값인 0이 출력된다

        br.close();
        bw.flush();
        bw.close();
    }

}