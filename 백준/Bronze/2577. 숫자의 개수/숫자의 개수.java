import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int result = n1 * n2 * n3;
        int length = Integer.toString(result).length();
        for(int i=0;i<length; i++){
            int digit = result % 10;
            count[digit] ++;
            result /= 10;
        }

        for(int i : count){
            bw.write(String.valueOf(i) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}