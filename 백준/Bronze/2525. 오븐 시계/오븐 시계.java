import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(stk.nextToken());
        int minute = Integer.parseInt(stk.nextToken());
        int duration = Integer.parseInt(br.readLine());

        int added_hour = hour;
        int added_minute = minute + duration;
        if (added_minute >= 60){
            int over_hour = added_minute / 60;
            added_hour += over_hour;
            added_minute -= over_hour * 60;
            if(added_hour >= 24){
                added_hour -= 24;
            }
        }

        bw.write(String.valueOf(added_hour) + " " + String.valueOf(added_minute));

        bw.flush();
        br.close();
        bw.close();
    }
}