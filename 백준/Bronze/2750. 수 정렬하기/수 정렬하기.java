import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        // 버블 정렬
        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }

        for(int n : data){
            bw.write(String.valueOf(n));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}