import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for(int i=0; i<T; i++){  // 테스트 케이스만큼 반복
            StringTokenizer stk = new StringTokenizer(br.readLine());  // 공백 기준 분할을 위한 StringTokenizer
            int R = Integer.parseInt(stk.nextToken());  // 글자당 반복횟수
            String S = stk.nextToken();  // 대상 문자열
            char[] str_list = S.toCharArray();  // 한 글자씩 분리

            for(char c : str_list){  // 각 글자마다 반복
                for(int j=0; j<R; j++){  // 한 글자에 대해서 반복횟수만큼 반복하며 출력
                    bw.write(c);
                }
            }
            bw.write("\n");  // 하나의 테스트 케이스가 끝나면 줄바꿈
        }

        bw.flush();
        br.close();
        bw.close();
    }

}