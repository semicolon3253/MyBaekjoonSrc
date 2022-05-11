import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();  // 입력 받는다
        char[] spell_list = input.toCharArray();  // 입력을 char 배열로 분리한다
        
        for(char c='a'; c<'z'+1; c++){  // char a부터 z까지 반복
            boolean is_find = false;  // 최초 위치를 찾았는지 여부를 저장할 변수
            for(int i=0; i< spell_list.length; i++){  // 입력을 한글자씩 반복한다
                if(spell_list[i] == c){  // 현재 글자와 찾으려는 알파벳이 같으면
                    bw.write(i + " ");  // 현재 위치 출력
                    is_find = true;  // 찾았다고 표시
                    break;
                }
            }
            if(!is_find){  // 못찾고 반복문을 빠져나온 경우 -1 출력
                bw.write("-1 ");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}