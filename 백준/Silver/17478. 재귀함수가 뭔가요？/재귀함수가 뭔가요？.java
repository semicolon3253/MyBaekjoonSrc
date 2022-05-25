import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");  // 시작 문장 출력
        printTalk(N);  // 함수 호출

        br.close();
    }

    static String bar = "";  // 문장 앞에 붙이 ____을 저장할 변수 시작값은 아무것도 없는 상태

    static void printTalk(int n){
        String current_bar = bar;  // 현재 회차에서 문장 앞에 붙여야 할 언더바를 저장한다

        System.out.println(current_bar + "\"재귀함수가 뭔가요?\"");

        if(n == 0){  // 횟수가 0이 되면 대답을 출력한다
            System.out.println(current_bar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }else{  // 아니면 이야기를 출력
            System.out.println(
                    current_bar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                            current_bar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                            current_bar +"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            bar += "____";  // 출력후 다음 회차 호출 전에 언더바를 추가해주기
            printTalk(n-1);  // n-1 상태로 호출
        }

        System.out.println(current_bar + "라고 답변하였지.");
    }
}