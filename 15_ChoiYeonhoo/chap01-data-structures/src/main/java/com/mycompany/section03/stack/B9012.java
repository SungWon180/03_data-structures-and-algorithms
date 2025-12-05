package com.mycompany.section03.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*문제

괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
* */

/* 문제 설명
 * - 입력된 문자열이 올바른 괄호 쌍으로 이루어져 있는지 판별
 * - '(', ')' 개수가 같아야 함.
 * - 모든 ')'는 자신보다 앞에있는 '('와 짝을 이뤄야 한다.
 * */

/* 해결 전략
 * - stack을 활용
 * - '('를 만나면 stack에 push
 * - ')'를 만나면 stack에서 pop
 * - 만약 비어있는데 pop을 시도한다 == '(' 없는데 ')'가 있음 -> 괄호 쌍이 안맞음
 *   --> No
 * - 모든 문자열을 순회하면서 push/pop을 수행 했는데 스택에 남은 '('가 있으면 -> 괄호 쌍이 안맞음
 *   --> No
 * */

public class B9012 {

  public static void main(String[] args) throws IOException  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 입력된 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
    int T = Integer.parseInt(br.readLine());

    for (int i = 0 ; i < T ; i++){
     sb.append(solution(br.readLine()));
     sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static String solution(String s) {

    // '(' 괄호를 담는 스택
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i); // 문자열에서 i번째 하나씩 추출

      // '(' 스택에 담기
      if (ch =='(') stack.push(ch);

      else { // ')' 인 경우
        // 비어있으면 == 짝이 맞지 않음 == "NO 반환
        if (stack.isEmpty()) return "NO";

        stack.pop();
         // '(' 하나 제거
      }
    }
    // 반복이 끝난 후에도 stack에 '(' 가 남아 있음 == 쌍이 맞지 않음 -> "No"
    if(!stack.isEmpty()) return "NO";

    return "YES"; // Yes / No
  }

}




