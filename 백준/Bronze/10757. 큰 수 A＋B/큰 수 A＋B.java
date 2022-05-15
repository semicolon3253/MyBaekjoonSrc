import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // BigInteger 같은걸 써도 되지만 재미없으니 직접 덧셈을 구현해보자

        StringTokenizer stk = new StringTokenizer(br.readLine());  // 두 수를 문자열로 받는다
        String str_A = stk.nextToken();
        String str_B = stk.nextToken();
        int arr_length = Math.max(str_A.length(), str_B.length()) + 1;  // 두 수 중 자리수가 더 긴쪽을 고른다. 마지막 자리에서의 받아올림을 고려해 거기에 1을 더한다

        char[] char_A = str_A.toCharArray();  // 입력된 숫자를 자리별로 쪼갠다
        char[] char_B = str_B.toCharArray();

        int[] A = new int[arr_length];  // 위에서 구한 자리수 만큼 int 배열을 만든다.
        int[] B = new int[arr_length];

        // int 배열의 뒤에서 부터 숫자를 하나씩 채운다. 여분은 기본값인 0이다.  ex) 1234 456 => [0, 1, 2, 3, 4], [0, 0, 4, 5, 6]
        for(int i=char_A.length, j=arr_length-1; i>0; i--, j--){
            A[j] = char_A[i-1] - 48;
        }
        for(int i=char_B.length, j=arr_length-1; i>0; i--, j--){
            B[j] = char_B[i-1] - 48;
        }

        // 결과의 각 자리를 저장할 배열.
        int[] result = new int[arr_length];
        for(int i=A.length-1; i>=0; i--){  // A배열의 길이만큼, 그리고 배열의 뒤에서 부터 읽는다. A와 B는 길이가 같으므로 뭐든 상관없음
            int this_A = A[i];  // 현재 읽을 숫자
            int this_B = B[i];

            int tmp = this_A + this_B;  // 현재 자리의 두 숫자를 더한다
            if(tmp >= 10){  // 만약 더한값이 10 이상이면
                result[i] = tmp - 10;  // 현재 자리의 계산 값에는 일의 자리만 저장하고
                A[i-1]++;  // 나머지 10은 다음 자리로 받아올림 한다
            }else{  // 아니면 그냥 저장
                result[i] = tmp;
            }
        }

        // 결과 배열을 큰 자리수부터(처음부터) 하나씩 출력한다
        for(int i=0; i< result.length; i++){
            if(i == 0 && result[i] == 0){  // 큰자리가 0이면 스킵. 0123 과 같이 출력되는 것을 막기 위함
                continue;
            }
            bw.write(String.valueOf(result[i]));
        }

        bw.flush();
        br.close();
        bw.close();
    }

}