import java.io.*;

public class Main {

    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];  // 그림을 저장할 이차원 배열을 만든다

        printStar(N, 0, 0, false);  // 0,0 부터 시작해서 그리기 시작

        for(int i=0; i<N; i++){  // 결과의 이차원 배열을 출력
            for(int j=0; j<N; j++){
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }


    // n은 현재 단계가 최하위 단계인지 확인하는데 쓴다. 즉 가장 작은 단위인 ***\n* *\n***을 그려야 하는지 체크한다.
    // x와 y는 현재 블록의 시작 좌표다
    // empty는 현재 블록을 모두 공백으로 할지 여부를 결정한다
    static void printStar(int n, int x, int y, boolean empty){
        int T = n / 3;  // T를 3으로 나눈다. 이게 반복되서 결과가 1이되면 최하위 단위라는 뜻이다
        int orig_x = x;  // 밑에서 변수 x에 연산을 하므로 원본 x를 따로 저장해둔다

        if(T == 1){  // 최하위 단계일 때
            for(int i=0; i<3; i++){  // 3x3의 가장 작은 패턴을 그린다
                for(int j=0; j<3; j++){
                    if(i==1 && j==1){  // 만약 3x3의 중간 지점이면 공백으로 둔다
                        map[y][x] = " ";
                    }else{
                        map[y][x] = empty ? " " : "*";  // 중간 지점이 아니더라도 empty가 참이면 모두 공백으로 그린다
                    }
                    x++;
                }
                x = orig_x;
                y++;
            }
        }else{
            for(int i=0; i<3; i++){  // 현재 단계를 3x3 블록 단위로 나눠서 반복한다
                for(int j=0; j<3; j++){
                    if(i==1 && j==1){
                        printStar(T, x, y, true);  // 중심 블록이면 공백을 그리도록 한다
                    }else{
                        printStar(T, x, y, empty);  // 아니면 공백 여부는 상위 단계에서 결정된 값으로 한다
                    }

                    x += T;
                }
                x = orig_x;
                y += T;
            }
        }
    }
}