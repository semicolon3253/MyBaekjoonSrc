import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count= Integer.parseInt(br.readLine());
        double[] score_list = new double[count];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        double M = 0;
        for(int i=0; i<score_list.length; i++){
            int score = Integer.parseInt(stk.nextToken());
            score_list[i] = score;
            
            if(score_list[i] >= M){
                M = score_list[i];
            }
        }

        double sum = 0;
        for(int i=0; i<score_list.length; i++){
            sum += score_list[i] / M * 100;
        }
        bw.write(String.valueOf(sum / score_list.length));

        bw.flush();
        br.close();
        bw.close();
    }
}