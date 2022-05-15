import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int middle = 0;
        int S = 1, E = 1;
        int group = 1;

        while(true){
            if(S<=X && X<=E){
                break;
            }

            S = E + 1;
            E = S + middle + 1;
            middle++;
            group++;
        }

        int x, y;
        if(group%2 == 0){
            x = E - X;
            y = X - S;
        }else{
            x = X - S;
            y = E - X;
        }

        bw.write((y+1) + "/" + (x+1));

        bw.flush();
        br.close();
        bw.close();
    }

}