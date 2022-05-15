import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] APT = new int[15][14];  // 아파트 전체를 이차원 배열로 구현
        APT[14] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};  // 0층의 데이터는 미리 작성

        // 아래층 부터 각 호의 인원 계산
        for(int i=13; i>=0; i--){
            int bottom_index = i+1;
            int sum = 0;

            for(int j=0; j<14; j++){
                sum += APT[bottom_index][j];
                APT[i][j] = sum;
            }
        }

        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());  // 층
            int n = Integer.parseInt(br.readLine());  // 호

            bw.write(String.valueOf(APT[14-k][n-1]));  // 층과 호에 맞는 데이터를 꺼내서 출력
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}