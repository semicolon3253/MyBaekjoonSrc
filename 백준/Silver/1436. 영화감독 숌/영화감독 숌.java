import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;  // 현재 종말의 수가 몇번째인지 저장

        int i = 666;  // 종말의 수를 저장. 굳이 1부터 할 필요 없이 666부터 바로 시작
        while(true){  // 무한 반복
            String num = String.valueOf(i);  // 현재 i를 문자열로 바꿈
            
            if(num.contains("666")){  // 만약 수에 666이 포함되있으면
                count++;  // 번호 +1
            }
            if(count == N){  // 만약 찾기를 원하는 번호와 count가 같으면 출력후 반복 중지
                bw.write(String.valueOf(i));
                break;
            }

            i++;
        }


        br.close();
        bw.flush();
        bw.close();
    }

}