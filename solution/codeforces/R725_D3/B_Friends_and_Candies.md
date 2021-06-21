# [Friends and Candies](https://codeforces.com/contest/1538/problem/B)

### 난이도

***
800
<br><br>

### 문제

***
Polycarp은 n 명의 친구를 가지고 있고, 그의 i-th는 ai 사탕을 가지고 있습니다. Polycarp의 친구들은 사탕 수가 다른 것을 좋아하지 않습니다. 즉, 그들은 모든 인공 지능이 동일하기를 원합니다.
이를 해결하기 위해 Polycarp은 다음과 같은 일련의 작업을 정확히 한 번 수행합니다.

Polycarp는 k (0≤k≤n)의 임의의 친구를 선택합니다 (지수 i1, i2,…, ik가있는 친구를 선택한다고 가정 해 봅시다); Polycarp는 모든 n 친구들에게 ai1 + ai2 +… + aik 사탕을
배포합니다. ai1 + ai2 +… + aik 사탕 각각을 배포하는 동안 그는 새로운 소유자를 선택합니다. n 명의 친구가 될 수 있습니다. 사탕은 유통 과정 전에 그 사탕을 소유 한 사람에게 줄 수 있습니다. 숫자
k는 미리 고정되어 있지 않으며 임의 일 수 있습니다. 당신의 임무는 k의 최소값을 찾는 것입니다.

예를 들어, n = 4이고 a = [4,5,2,5]이면 Polycarp은 다음과 같은 사탕 분포를 만들 수 있습니다.

Polycarp은 i = [2,4] 인덱스로 k = 2 친구를 선택하고 a2 + a4 = 10 사탕을 배포하여 a = [4,4,4,4]를 만듭니다 (사탕 2 개는 사람 3에게갑니다). 이 예에서 Polycarp는 k
= 1 친구를 선택할 수 없으므로 사탕을 재배포하여 결국 모든 ai가 동일하게됩니다.

데이터 n과 a에 대해 최소값 k를 결정합니다. 이 값 k를 사용하면 Polycarp는 친구 k 명을 선택하고 사탕을 재배포하여 모든 사람이 같은 수의 사탕을 갖게됩니다.

<br><br>

### 입력

***
첫 번째 줄에는 하나의 정수 t (1≤t≤104)가 포함됩니다. 그런 다음 t 테스트 케이스가 따릅니다.

각 테스트 케이스의 첫 번째 줄에는 하나의 정수 n이 포함됩니다 (1≤n≤2⋅105).

두 번째 줄에는 n 개의 정수 a1, a2,…, an (0≤ai≤104)이 있습니다.

모든 테스트 케이스에서 n의 합이 2⋅105를 초과하지 않음을 보장합니다.
<br><br>

### 출력

***
각 테스트 케이스 출력에 대해 :

Polycarp가 원하는 방식으로 사탕을 재배포 할 수 있도록 정확히 k 명의 친구를 선택할 수 있도록 k의 최소값; 그러한 값 k가 없으면 "-1".
<br><br>

#### 예제 입력 1

> 5     
4       
4 5 2 5     
2       
0 4     
5       
10 8 5 1 4      
1       
10000       
7       
1 1 1 1 1 1 1

#### 예제 출력 1

> 2     
1       
-1      
0       
0

<br><br>

### 알고리즘 분류

***

* greedy
* math

<br><br>

### Solution

***

해결법은 전체 평균 사탕의 갯수보다 더 많은 사탕을 가지고 있는 사람를 세면 된다.

너무 쉬운 문제이므로 더이상의 설명은 생략한다.

<br><br>

### [전체 코드](https://github.com/Jungmin-Seo0527/CodingTest/blob/main/src/codeforces/R725_D3/B_Friends_and_Candies.java)