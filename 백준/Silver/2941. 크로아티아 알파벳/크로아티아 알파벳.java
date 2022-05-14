import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] word_list = br.readLine().toCharArray();  // 입력을 한글자씩 나눈다
        int count = 0;  // 개수를 셀 변수

        for(int offset=0; offset< word_list.length; offset++){  // offset으로 읽을 글자의 위치를 정한다
            char this_word = word_list[offset];  // 현재 읽을 글자를 가져온다
            if(offset+1 >= word_list.length){  // 현재 글자가 마지막이면 개수 +1하고 종료
                count++;
                break;
            }
            char next_word = word_list[offset+1];  // 다음 글자를 가져온다

            // 시작 문자를 비교하고 또 다음 문자도 비교한다. 크로아티아 알파벳이면 offset을 증가하되 for 루플에서 한번더 +1되므로 실제 보다 1작게 증가한다
            if(this_word == 'c'){
                if(next_word == '=' || next_word == '-'){
                    offset++;
                }
            }else if(this_word == 'd'){
                if(next_word == '-'){
                    offset++;
                }else if(next_word == 'z'){
                    if(offset+2 < word_list.length){  // 다음 다음 글자를 가져올 수 있으면
                        if(word_list[offset+2] == '='){
                            offset+=2;
                        }
                    }
                }
            }else if(this_word == 'l'){
                if(next_word == 'j'){
                    offset++;
                }
            }else if(this_word == 'n'){
                if(next_word == 'j'){
                    offset++;
                }
            }else if(this_word == 's'){
                if(next_word == '='){
                    offset++;
                }
            }else if(this_word == 'z'){
                if(next_word == '='){
                    offset++;
                }
            }

            count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }

}