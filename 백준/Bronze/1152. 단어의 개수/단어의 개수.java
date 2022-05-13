import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();  // 입력을 받는다
        char[] word_list = input.toCharArray();  // 한글자씩 쪼갠다
        int count = 0;  // 수를 샐 변수
        int start_index = 1;  // 루프를 시작할 글자의 위치
        char prev_word = word_list[0];  // 이전 글자를 저장할 변수. 처음에는 첫글자로 시작

        if(prev_word == ' '){  // 만약 공백으로 시작하면
            start_index++;  // 그다음 글자부터 루프. 공백이 연속되지 않으니 그 다음 글자는 공백이 아니다

            if(word_list.length == 1){  // 공백으로 시작하는데 그 한글자 밖에 없는 경우: 입력이 공백 한글자만 있는 경우
                count--;  // 뒤에서 count +1을 했을 때 개수가 1되는 것을 막기 위해 -1로 만든다
            }else{
                prev_word = word_list[1];  // 두번째 글자를 이전 글자로 둔다
            }
        }

        for (int i=start_index; i<word_list.length; i++) {  // 두번째 글자부터 한글자씩 반복
            char now_word = word_list[i];  // 현재 글자

            if(prev_word == ' ' && now_word != ' '){  // 이전 글자가 공백이고 현재 글자가 공백이 아니면
                count++;  // 1증가
            }

            prev_word = now_word;  // 현재 글자를 이전 글자로
        }

        bw.write(String.valueOf(count+1));  // 센 수에서 1을 더한다

        bw.flush();
        br.close();
        bw.close();
    }
}