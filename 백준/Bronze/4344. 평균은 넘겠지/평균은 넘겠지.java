import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int people_count = Integer.parseInt(stk.nextToken());

            int[] score_list = new int[people_count];
            int sum = 0;
            for(int j=0; j<people_count; j++){
                score_list[j] = Integer.parseInt(stk.nextToken());
                sum += score_list[j];
            }
            double average = sum / people_count;
            int over_average = 0;
            for(int k=0; k<people_count; k++){
                if(score_list[k] > average){
                    over_average++;
                }
            }
            bw.write(String.format("%.3f", (double)(over_average) / (double)(people_count) * 100d));
            bw.write("%\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}