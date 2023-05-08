import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Algo1 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    ### 로봇 경주장(토끼)
    - 5마리 토끼, 완주
    - 오르막, 내리막: 각 지점마다 다른 높이
    - 토끼별로 오르막 한계, 내리막 한계 존재
     */
    static int[][] rabbitLimit;
    static int[] route;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");

            //초기화
            rabbitLimit = new int[5][2]; // 5마리, 2가지 한계
            route = new int[10]; // 10개
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 10; i++) {
                route[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 2; j++) {
                    rabbitLimit[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //경기 시작
            int r = raceStart();
            bw.write(r + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int raceStart() {
        int r = 0; // 완주 토끼 수
        for (int i = 0; i < 5; i++) {
            boolean turn = true;
            for (int j = 1; j < 10; j++) {
                int gap = route[j] - route[j - 1];
                //gap이 양수인 경우 == 오르막
                if (gap >= 0 && gap > rabbitLimit[i][0]) {
                    turn = false;
                    break;
                }
                //gap이 음수인 경우 == 내리막
                else if (gap < 0 && Math.abs(gap) > rabbitLimit[i][1]) {
                    turn = false;
                    break;
                }
            }
            if (turn) {
                r++;
            }
        }
        return r;
    }
}
