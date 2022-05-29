import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());

        map = new char[h][];
        for(int i=0; i<h; i++){
            map[i] = br.readLine().toCharArray();  // 입력 받은 체스판을 이차원 배열로 만든다
        }

        int MIN = Integer.MAX_VALUE;

        for(int x=0; x<=w-8; x++){  // 해당 체스판을 8x8 단위로 쪼개서 모든 경우를 반복한다
            for(int y=0; y<=h-8; y++){
                int count_W = count(x, y, 'W');  // 각 8x8 판에 대해서 흰색이나 검은색으로 시작할 때 바꿔야할 칸의 수를 각각 구한다
                int count_B = count(x, y, 'B');

                if(count_W < MIN){  // 두 케이스 중 최소값이 전체 최소값보다 작을 경우 저장한다
                    MIN = count_W;
                }
                if(count_B < MIN){
                    MIN = count_B;
                }
            }
        }

        bw.write(String.valueOf(MIN));


        br.close();
        bw.flush();
        bw.close();
    }

    static int count(int x, int y, char c){
        int count = 0;
        char target = c;  // 원래 대로라면 현재 칸에 와야 되는 색을 저장.

        for(int i=y; i<y+8; i++){  // 시작 좌표로부터 8x8 칸을 하나씩 훑는다
            for(int j=x; j<x+8; j++){
                char current_color = map[i][j];  // 현재 칸의 색을 가져온다
                if(current_color != target){  // 현재 칸의 색이 원래 있어야 할 색과 다르면 +1
                    count++;
                }

                if(target=='W'){  // 다음 색은 현재와 다른 색이므로 바꿔준다
                    target='B';
                }else{
                    target='W';
                }
            }
            if(target=='W'){  // 한 줄이 끝나도 바꿔준다
                target='B';
            }else{
                target='W';
            }
        }

        return count;
    }
}