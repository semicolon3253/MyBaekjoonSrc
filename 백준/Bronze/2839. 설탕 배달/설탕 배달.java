import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(N>0){  // 남아있는 설탕이 0kg 초과일 때만 반복
            if(N%5 == 0){  // 만약 남아있는 설탕이 5의 배수이면 5kg으로 묶는것이 최소이다
                count += N/5;
                break;
            }else{  // 만약 5로 나누어떨어 지지 않는다면 3kg만큼 한번 뺀다
                N -= 3;
                count++;
            }

            if(N<0){  // 그렇게 3kg만큼 뺐는데 양이 음수가 되버리면 그것은 정확히 나눌수 없는 양이다
                count = -1;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }

}