import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = System.in.read();

        bw.write(String.valueOf(input));

        bw.flush();
        bw.close();
    }

}