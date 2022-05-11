import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char input = br.readLine().toCharArray()[0];

        bw.write(String.valueOf((int) input));
        
        bw.flush();
        br.close();
        bw.close();
    }

}