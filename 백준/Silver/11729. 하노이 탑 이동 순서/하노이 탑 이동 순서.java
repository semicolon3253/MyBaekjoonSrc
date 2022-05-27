import java.io.*;

public class Main {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 개수를 가져온다

        int K = (int) (Math.pow(2, N) - 1);  // 이동횟수는 공식에 넣고 출력
        bw.write(K + "\n");

        hanoiMove(N, 1, 2, 3);  // 이동한다. 첫번째 막대의 N개(모든) 원반을 세번째로 이동한다

        br.close();
        bw.flush();
        bw.close();
    }

    static void hanoiMove(int n, int from, int middle, int to) throws IOException {
        if(n == 1){  // 옮긴 원반 수가 1개라면 바로 옴긴다
            bw.write(from + " " + to + "\n");
        }else {  // 아니면
            hanoiMove(n - 1, from, to, middle);  // 가장 밑 원반을 제외한 n-1개의 원반을 from에서 middle 막대로 옮긴다
            bw.write(from + " " + to + "\n");  // 옮기지 않은 가장 큰 원반을  from에서 to 막대로 옮긴다
            hanoiMove(n - 1, middle, from, to);  //  나머지 원반을 middle에서 to 막대로 옮긴다
        }
    }

}