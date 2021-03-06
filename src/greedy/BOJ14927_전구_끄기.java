/*
    BOJ14927_전구_끄기
    --------------------------------------------------------------------------------------------------------------------
    문제

    홍익이는 N x N 전구 판을 가지고 있다. 전구 판에는 각 칸마다 전구가 하나씩 연결되어 있다.
    이 전구 판에서 하나의 전구를 누르면, 해당 전구를 포함하여 상하좌우의 총 5개 전구들의 상태가 변화한다.
    다시 말해, 5개의 전구들 중 불이 켜져 있던 전구는 불이 꺼지고, 불이 꺼져 있던 전구는 불이 켜진다.
    홍익이는 현재 전구 판의 상태를 보고 최대한 적은 횟수로 전구들을 눌러 전구판의 모든 전구를 끄고 싶다.

    홍익이를 도와서 전구 판의 모든 전구를 끌 수 있는 최소 횟수 B를 알아보자.

    만약, 전구를 끌 수 있는 방법이 없다면, -1을 출력하도록 한다.
    --------------------------------------------------------------------------------------------------------------------
    입력

    N
    0과 1로 이루어진 NxN 행렬
    2 <= N <= 18
    --------------------------------------------------------------------------------------------------------------------
    출력

    B
    --------------------------------------------------------------------------------------------------------------------
    예제 입력 1

    2
    1 1
    1 1
    --------------------------------------------------------------------------------------------------------------------
    예제 출력 1

    4
    --------------------------------------------------------------------------------------------------------------------
    예제 입력 2

    3
    0 0 0
    0 0 0
    0 0 1
    --------------------------------------------------------------------------------------------------------------------
    예제 출력 2

    5
    --------------------------------------------------------------------------------------------------------------------
    예제 입력 3

    5
    0 0 0 1 0
    1 1 0 1 1
    1 1 1 0 1
    1 1 0 0 0
    0 0 0 0 1
    --------------------------------------------------------------------------------------------------------------------
    예제 출력 3

    -1
    --------------------------------------------------------------------------------------------------------------------
    풀이

    BOJ14939_불끄기 문제와 완전히 동일한 문제
    전체적인 불끄는 경우는 그리디한 접근으로 판단
    첫번째 행에 대한 불끄는 판단은 모든 경우의 수를 생각하는 브루트 포스(경우의 수는 비트 마스킹)
    --------------------------------------------------------------------------------------------------------------------
 */
package greedy;

import java.io.*;
import java.util.*;

public class BOJ14927_전구_끄기 {
    static int N;
    static char[][] map;

    static int[] v_r = {0, 1, -1, 0, 0};
    static int[] v_c = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        inputAndSettingData();
        solve();
    }

    static void solve() {
        int ans = Integer.MAX_VALUE;
        char[][] copy = new char[N][N];

        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        for (int bit = 0; bit < (1 << N); bit++) {
            for (int i = 0; i < N; i++) {
                map[i] = copy[i].clone();
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    change(0, i);
                    cnt++;
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i - 1][j] == '1') {
                        change(i, j);
                        cnt++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (map[N - 1][i] == '1') {
                    cnt = Integer.MAX_VALUE;
                    break;
                }
            }

            ans = Math.min(ans, cnt);
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    static void change(int row, int col) {
        for (int i = 0; i < 5; i++) {
            int nr = row + v_r[i];
            int nc = col + v_c[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == '0') map[nr][nc] = '1';
                else map[nr][nc] = '0';
            }
        }
    }

    static void inputAndSettingData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
    }
}
