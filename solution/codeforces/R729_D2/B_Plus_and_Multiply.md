# [Plus and Multiply](https://codeforces.com/contest/1542/problem/B)

### 난이도

***
??
<br><br>

### 문제

***
다음과 같이 생성 된 무한 세트가 있습니다.

1이 세트에 있습니다. x가이 세트에 있으면 x⋅a와 x + b가 모두이 세트에 있습니다. 예를 들어, a = 3 및 b = 6 인 경우 집합에서 가장 작은 5 개의 요소는 다음과 같습니다.

1, 3 (1이이 세트에 있으므로 1⋅a = 3이이 세트에 있음), 7 (1이이 세트에 있으므로 1 + b = 7이이 세트에 있음), 9 (3이이 세트에 있으므로 3⋅a = 9가이 세트에 있음), 13 (7이이
세트에 있으므로 7 + b = 13이이 세트에 있음). 양의 정수 a, b, n이 주어지면 n이이 세트에 있는지 확인합니다.

<br><br>

### 입력

***
입력은 여러 테스트 케이스로 구성됩니다. 첫 번째 줄에는 테스트 케이스 수인 정수 t (1≤t≤105)가 포함됩니다. 테스트 케이스에 대한 설명은 다음과 같습니다.

각 테스트 케이스를 설명하는 유일한 줄에는 단일 공백으로 구분 된 세 개의 정수 n, a, b (1≤n, a, b≤109)가 포함됩니다.
<br><br>

### 출력

***
각 테스트 케이스에 대해 n이이 세트에 있으면 "Yes"를 인쇄하고 그렇지 않으면 "No"를 인쇄하십시오. 어떤 경우에도 각 문자를 인쇄 할 수 있습니다.
<br><br>

#### 예제 입력 1

> 5     
24 3 5      
10 3 6      
2345 1 4        
19260817 394 485        
19260817 233 264

#### 예제 출력 1

> Yes       
No      
Yes     
No      
Yes

<br><br>

### Note

***

첫 번째 테스트 케이스에서 24는 다음과 같이 생성됩니다.

1이이 세트에 있으므로 3과 6이이 세트에 있습니다.       
3이이 세트에 있으므로 9와 8이이 세트에 있습니다.       
8이이 세트에 있으므로 24와 13이이 세트에 있습니다.         
따라서 우리는이 세트에 24가 있음을 알 수 있습니다.

두 번째 테스트 케이스에서 세트의 가장 작은 5 개 요소는 명령문에 설명되어 있습니다. 10 개가 그들 중 하나가 아니라는 것을 알 수 있습니다.

<br><br>

### 알고리즘 분류

***

* constructive algorithms
* math
* number theory

<br><br>

### Solution

***

이 문제를 무작위로 식을 만들어 보자면       
`a^2 + a^2*b + a*b + ...` 이런 식으로 나아 간다.

다시 정리해보자면 처음 숫자는 1로 시작한다. 여기서 *a, +b를 할 수 있다.       
*a 는 그대로 a가 된다. +b는 1+b가 된다. 여전히 1은 살아 있다. *a가 나오기 전까지는 1은 살아 있을 것이고, a가 나온만큼 a 제곱수가 될 것이다. 그리고 나머지들은 a와 b로 이루어진 숫자가
되어있을 것이다. 1은 단 하나였기에 맨 처음항을 제외하고는 a로만 이루어져 있거나, b로만 이루어져 있는 항은 존재할 수 없다. (이는 무작위로 식을 한번 세워보면 금방 알수 있을 것이다.**정수론...**)

이러한 꼴로 n을 만들 수 있는가를 판별하기 위해서는 맨 앞에 존재하는 a제곱수를 뺀 값이 b에 나누어 떨어지는지 확인하면 된다. 나누어 떨어지면 어떠한 방법으로든 n을 만들 수 있다.

```java
public class Main {
    static String solve(int a, int b, int n) {
        for (int i = 1; i <= n; i *= a) {
            if ((n - i) % b == 0) {
                return "Yes";
            }
        }
        return "No";
    }
}
```

n보다 작은 a의 모든 제곱수를 빼보면서 b와 나누어 떨어지는지 확인해서 n을 만들수 있는지 확인했다. 그런데 여기서 예외가 존재한다. `a = 1`인 경우이다.      
반복문을 보면 i에 a를 계속 곱해주면서 n이하의 모든 제곱수를 확인하지만 `a = 1`인 경우는 반복문을 탈출할 수 없다.(당연히 1 * 1 = 1이기 때문에...)

따라서 `a = 1`인 경우에는 아무리 *a를 해주어도 맨 처음 항은 항상 1이기 때문에 1을 빼주고 b로 나누어 떨어지는지만 확인하면 된다.

```java
public class Main {
    static String solve(int a, int b, int n) {
        if (a == 1) {
            if ((n - 1) % b == 0) {
                return "Yes";
            } else {
                return "No";
            }
        }

        for (int i = 1; i <= n; i *= a) {
            if ((n - i) % b == 0) {
                return "Yes";
            }
        }
        return "No";
    }
}
```

> 정수론의 contructive algorithm 문제였다. 답에 근접한 풀이였다고 생각했지만 a = 1인 예외를 잡지 못해서 test2에서 계속 시간초과가 일어났다.
>
> 처음에 a로 나누어 떨어지면 a로 계속 나누고, 그렇지 않으면 b를 빼주었다. 이 방법도 마찬가지로 test2에서 시간초과가 일어난다. 정수론 까지는 아니더라도 미지수로 식을 세워보면서 풀어봤으면 해볼만한 문제가 아니었나 생각한다.

<br><br>

### [전체 코드](https://github.com/Jungmin-Seo0527/CodingTest/blob/main/src/codeforces/R729_D2/B_Plus_and_Multiply.java)
