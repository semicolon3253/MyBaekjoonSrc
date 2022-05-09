import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] remainder_list = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int count = 0;
        for(int i=0; i<10; i++){
            remainder_list[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for(int i=0; i<10; i++){
            boolean duplicate = false;
            for(int j=i+1; j<10; j++){
                if(remainder_list[i] == remainder_list[j]){
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate){
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
}