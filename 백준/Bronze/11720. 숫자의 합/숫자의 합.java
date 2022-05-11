import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 숫자의 개수를 입력받는다.
        int sum = 0;  // 총 합을 저장할 변수
        for(int i=0; i<N; i++){  // 문자의 개수만큼 반복한다.
            // 한글자씩 읽어온다. 이 때 read()는 글자의 아스키코드를 반환한다.
            // 0의 아스키코드는 48이고 이후로 숫자와 아스키 코드가 1씩 커지므로 글자의 아스키코드에서 48을 빼면 실제 숫자가 나온다.
            // ex) 7의 아스키 코드는 55다. 55 - 48 = 7
            sum += (br.read() - 48);
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        br.close();
        bw.close();
    }

}