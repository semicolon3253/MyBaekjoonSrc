import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 입력받은 방 번호
        int count = 1;  // 거쳐간 방 개수
        int range_start = 0;  // 범위의 시작
        int range_end = 1;  // 범위의 끝
        int m = 6;  // 한 단계 마다 증가시킬 범위 사이의 개수

        while(true){
            if(range_start <= N && N <= range_end){
                break;  // 주어진 방이 해당 범위에 있으면 정지
            }

            count++;  // 거쳐간 방 개수 +1
            // 아래 코드는 거쳐간 범위를 출력해준다
            // System.out.println(range_start + "~" + range_end);

            range_start = range_end + 1;  // 새로운 범위의 시작은 현재 범위의 끝 +1
            range_end += m;  // 새로운 범위의 끝은 현재 범위 끝에서 m만큼 더한값
            m += 6;  // 매 단계마다 m은 6씩 더해준다
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }

}