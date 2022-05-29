import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 사람 수
        int[] weight = new int[N];  // 각 사람의 몸무게 저장
        int[] height = new int[N];  // 각 사람의 키 저장
        int[] rank = new int[N];  // 각 사람의 등수 저장

        for(int i=0; i<N; i++){  // 사람 수 만큼 루프 돌면서 데이터 받음
            String[] data = br.readLine().split(" ");
            weight[i] = Integer.parseInt(data[0]);
            height[i] = Integer.parseInt(data[1]);
        }

        for(int i=0; i<N; i++){
            int this_weight = weight[i];  // 한사람씩 데이터 꺼내서 저장
            int this_height = height[i];
            int this_rank = 0;

            for(int j=0; j<N; j++){  // 나머지 사람들과 비교하며 더 큰 사람이 있으면 등수 1 추가
                if(weight[j]>this_weight && height[j]>this_height){
                    this_rank++;
                }
            }

            rank[i] = this_rank + 1;  // 등수 저장
        }

        for(int r : rank){
            bw.write(r + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}