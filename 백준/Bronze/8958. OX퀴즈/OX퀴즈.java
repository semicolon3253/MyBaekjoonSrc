import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            int score = 0;
            char[] answer_list = br.readLine().toCharArray();
            int O_count = 0;
            for(int j=0; j<answer_list.length; j++){
                char answer = answer_list[j];

                if(answer == 'O'){
                    O_count++;
                }else{
                    O_count = 0;
                }
                score += O_count;
            }

            bw.write(String.valueOf(score) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}