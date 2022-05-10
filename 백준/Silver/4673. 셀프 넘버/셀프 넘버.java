import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] is_self_number = new boolean[10000];
        Arrays.fill(is_self_number, Boolean.TRUE);

        for(int i=1; i<=10000; i++){
            int after_d = d(i);
            if(after_d - 1 >= 10000) continue;
            is_self_number[after_d - 1] = false;
        }

        for(int i=0; i<10000; i++){
            if(is_self_number[i]){
                bw.write(String.valueOf(i+1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static int d(int n){
        int result = n;
        while(n != 0){
            result += n%10;
            n /= 10;
        }
        return result;
    }

}