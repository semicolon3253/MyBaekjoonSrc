import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();  // 단어를 입력받는다
        char[] str_list = input.toCharArray();  // 한글자씩 분리한다
        int[] count_list = new int[26];  // 알파벳 26자 각각에 대한 출현 횟수를 저장할 배열이다
        int max = -1, max_index = -1;  // 최대 빈도 알파벳의 출현 횟수와 count_list의 인덱스를 저장한다

        // 현재 글자
        for(char this_char : str_list) {  // 한글자씩 반복한다
            int idx = -1;  // count_list 상의 인덱스이다

            // 대소문자를 구분하지 않는다. 그러므로 예를 들어 a든지 A든지 count_list의 0번 인덱스에 횟수를 +1해줘야한다.
            // 그 인덱스를 구한다.
            if (65 <= this_char && this_char <= 90) {  // 대문자이면
                idx = this_char - 65;  // A의 아스키 코드는 65
            } else {  // 아니면 (소문자이면)
                idx = this_char - 97;  // a의 아스키 코드는 97
            }

            count_list[idx]++;  // 해당 count_list에 +1해준다
            if (count_list[idx] >= max) {  // 최고값이 갱신되면 최고값의 출현 빈도와 count_list의 인덱스를 저장한다
                max = count_list[idx];
                max_index = idx;
            }
        }

        int max_count = 0;  // 최대값의 출현횟수: 동일한 최대값이 여러개 있는지 확인한다
        for(int count : count_list){  // 출현 횟수 배열을 돌면서 최댓값이 몇 번 나왔는지 센다
            if(count == max){
                max_count++;
            }
        }

        if(max_count > 1){  // 출현 횟수가 최대값인 글자가 여러개면 ? 출력
            bw.write("?");
        }else{  // 아니면 해당 글자를 대문자로 출력
            bw.write(max_index + 65);
        }

        bw.flush();
        br.close();
        bw.close();
    }

}