import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();  // 입력을 한글자씩 분리한다
        int time = 0;  // 시간을 저장할 변수

        for(char ch : input){  // 한글자씩 반복
            switch (ch){  // 스위치 케이스 문으로 각 글자에 대해 시간을 증가시킨다
                case 'A': case 'B': case 'C':
                    time += 3;
                    break;
                case 'D' : case 'E': case 'F' :
                    time += 4;
                    break;
                case 'G' : case 'H': case 'I' :
                    time += 5;
                    break;
                case 'J' : case 'K': case 'L' :
                    time += 6;
                    break;
                case 'M' : case 'N': case 'O' :
                    time += 7;
                    break;
                case 'P' : case 'Q': case 'R' : case 'S' :
                    time += 8;
                    break;
                case 'T' : case 'U': case 'V' :
                    time += 9;
                    break;
                case 'W' : case 'X': case 'Y' : case 'Z' :
                    time += 10;
                    break;
            }
        }

        bw.write(String.valueOf(time));  // 출력

        bw.flush();
        br.close();
        bw.close();
    }

}