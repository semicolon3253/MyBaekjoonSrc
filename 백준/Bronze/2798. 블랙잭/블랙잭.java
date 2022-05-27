import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] CARD = new int[N];
        for(int i=0; i<N; i++){
            CARD[i] = Integer.parseInt(line2[i]);
        }

        int MAX = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    int sum = CARD[i] + CARD[j] + CARD[k];
                    
                    if(sum <= M && sum > MAX){
                        MAX = sum;
                    }
                }
            }
        }

        bw.write(String.valueOf(MAX));

        br.close();
        bw.flush();
        bw.close();
    }

}