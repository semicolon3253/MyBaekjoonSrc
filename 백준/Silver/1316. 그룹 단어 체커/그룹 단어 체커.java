import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수
        int count = 0;  // 그룹 단어 개수

        for(int i=0; i<num; i++){  // 테스트 케이스만큼 반복
            int[] state = new int[26];  // 알파벳 26자에 대한 상태를 저장할 변수: 기본값 0으로 초기화됨
            char[] word_list = br.readLine().toCharArray();  // 단어를 읽어와 한 글자씩 분리한다

            for(int j=0; j<word_list.length; j++){  // 한 글자씩 반복
                char this_word = word_list[j];  // 현재 글자
                int idx = this_word-97;  // 현재글자에서 97을 빼서 몇번째 알파벳인지 구한다

                // 상태는... 0=등장한적 없음  1=연속 시작  2=한번의 연속이 종료됨  3=이미 연속됐던게 또 나옴  ...으로 하기로 한다
                if(state[idx] == 2){  // 이미 연속이 한번 나왔던게 또 나오면 3으로 만든다
                    state[idx]++;
                }
                if(state[idx] == 0){  //이번에 처음 나온 글자면 1로 만든다
                    state[idx]++;
                }
                if(state[idx] == 1){  // 연속이 시작된 글자에 대해...
                    if(j+1<word_list.length){  // 다음 글자를 가지고 올 수 있으면
                        char next_word = word_list[j+1];
                        if(this_word != next_word){  // 현재 글자와 다음 글자가 다르면
                            state[idx]++;  // 연속이 끝났다는 것이므로 2로 만든다
                        }
                    }else{  // 현재 글자가 마지막이라 다음 글자가 없으면 2로 만들어 연속을 종료한다
                        state[idx]++;
                    }
                }
            }

            boolean is_group = true;  // 그룹 단어인지 여부
            for(int s : state){  // 상태를 하나씩 꺼내본다
                if(s == 3){  // 만약 한번이라도 연속된게 또 나온적이 있다면
                    is_group = false;  // 그룹 글자가 아니다
                    break;
                }
            }
            if(is_group){  // 그룹 글자일때만 +1
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }

}