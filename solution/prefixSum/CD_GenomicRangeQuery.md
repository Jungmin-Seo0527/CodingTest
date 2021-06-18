# [GenomicRangeQuery](https://app.codility.com/c/run/trainingWFNRAJ-HVV/)

### 난이도

***
Respectable
<br><br>

### 문제

***
DNA 서열은 문자 A, C, G 및 T로 구성된 문자열로 나타낼 수 있으며, 이는 서열의 연속 뉴클레오티드 유형에 해당합니다. 각 뉴클레오티드에는 정수인 영향 계수가 있습니다. 유형 A, C, G 및 T의
뉴클레오티드는 각각 1, 2, 3 및 4의 영향 계수를 갖습니다. 다음과 같은 형식의 몇 가지 질문에 답할 것입니다. 주어진 DNA 서열의 특정 부분에 포함 된 뉴클레오티드의 최소 영향 계수는 무엇입니까?

DNA 시퀀스는 N 개의 문자로 구성된 비어 있지 않은 문자열 S = S [0] S [1] ... S [N-1]로 제공됩니다. 비어 있지 않은 배열 P 및 Q에 제공되는 M 쿼리가 있으며 각각 M 개의 정수로
구성됩니다. K 번째 쿼리 (0 ≤ K <M)에서는 위치 P [K]와 Q [K] (포함) 사이의 DNA 시퀀스에 포함 된 뉴클레오티드의 최소 영향 계수를 찾아야합니다.

예를 들어, 문자열 S = CAGCCTA 및 배열 P, Q를 다음과 같이 고려하십시오.

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6

이러한 M = 3 쿼리에 대한 답변은 다음과 같습니다.

위치 2와 4 사이의 DNA 부분에는 영향 계수가 각각 3과 2 인 뉴클레오티드 G와 C (두 번)가 포함되어 있으므로 답은 2입니다. 위치 5와 5 사이의 부분에는 영향 계수가 4 인 단일 뉴클레오티드 T가
포함되어 있으므로 답은 4입니다. 위치 0과 6 사이의 부분 (전체 문자열)에는 모든 뉴클레오티드, 특히 영향 계수가 1 인 뉴클레오티드 A가 포함되어 있으므로 답은 1입니다. 함수 작성 :

class Solution {public int [] solution (String S, int [] P, int [] Q); }

N 개의 문자로 구성된 비어 있지 않은 문자열 S와 M 개의 정수로 구성된 두 개의 비어 있지 않은 배열 P 및 Q가 주어지면 모든 쿼리에 대한 연속 응답을 지정하는 M 개의 정수로 구성된 배열을 반환합니다.

결과 배열은 정수 배열로 반환되어야합니다.

예를 들어, 문자열 S = CAGCCTA 및 배열 P, Q가 다음과 같을 때 :

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6

함수는 위에서 설명한대로 [2, 4, 1] 값을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오.

N은 [1..100,000] 범위 내의 정수입니다. M은 [1..50,000] 범위 내의 정수이고; 배열 P, Q의 각 요소는 [0..N-1] 범위 내의 정수입니다. P [K] ≤ Q [K], 여기서 0 ≤ K <
M; 문자열 S는 대문자 영문 A, C, G, T로만 구성됩니다.

<br><br>

### 알고리즘 분류

***

* 누적 합

<br><br>

### Solution

***

처음으로 코딜리티 문제를 남겨본다. 문제가 영어라서 자신있게 구글 번역기를 돌렸다. 문제를 풀때마다 번역기와 함께하고 있는데 이 친구가 실제 시험때도 함께 할수 있는지는 미지수이다.

처음에는 누구나 떠올릴 수 있는 방법으로 풀었다. 시키는 대로 구간의 최소값을 구했지만 시간초과가 나온다. 많은 쿼리문이 등장하는 구간의 최소값을 구하는 방법은 다양한 방법이 있다. 그중에서 나는 누적합을 이용해서
풀어냈다.(구간 쿼리의 대표 알고리즘인 세그먼트 트리로도 풀릴것 같다.)

* 누적합 배열은 각 문자열의 누적 빈도수를 저장한다.
    ```java
    public class Solution {
        public int[] solution(String S, int[] P, int[] Q) {
            for (int i = 0; i < S.length(); i++) {
                A[i + 1] += A[i];
                C[i + 1] += C[i];
                G[i + 1] += G[i];
                char c = S.charAt(i);
                if (c == 'A') {
                    A[i + 1]++;
                } else if (c == 'C') {
                    C[i + 1]++;
                } else if (c == 'G') {
                    G[i + 1]++;
                }
            }
        }
    }
    ```
    * 이로써 구간에서의 각각의 문자열의 빈도를 O(1)로 구할 수 있다.
        * 만일 [s1 s2]구간에서의 A문자열의 빈도수는 A[s2 + 1] - A[s1]식으로 구할 수 있다.

* 각 문자열의 빈도수를 구해주고 빈도수가 0이상인 문자열 중에 `A -> C -> G -> T`우선순위로 가장 먼저 나오는 것을 반환한다.
    ```java
    public class Solution {
        public int[] solution(String S, int[] P, int[] Q) {
            for(int i = 0; i < P.length; i++) {
                int start = P[i];
                int end = Q[i];
                int cntA = A[end + 1] - A[start];
                int cntC = C[end + 1] - C[start];
                int cntG = G[end + 1] - G[start];
                int cntT = end - start + 1 - cntA - cntC - cntG;
                // System.out.println("A="+cntA+" C="+cntC+" G="+cntG+" T="+cntT);
                ans[i] = getMin(cntA, cntC, cntG, cntT);
            }
        }
    }
    ```
    * **최소 빈도수의 문자열을 구하는 것이 아닌 빈도수가 0이상인 문자열 중에 위에서 설명한 우선순위대로 먼저 나오는 문자열을 반환해야 한다.**
    * 사실 최소 빈도수를 구해서 한번 틀렸다.

<br><br>

### [전체 코드](https://github.com/Jungmin-Seo0527/CodingTest/blob/main/src/prefixSum/CD_GenomicRangeQuery.java)