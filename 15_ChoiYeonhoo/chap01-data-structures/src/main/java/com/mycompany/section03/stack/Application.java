package com.mycompany.section03.stack;

import java.util.Stack;

public class Application {


  /* Stack
  * - 후입 선출(Last In First Out - LIFO) 원칙을 따르는 선형 자료 구조
  *
  * Java 제공 Stack 클래스
  * - java.util 패키지
  * - Vector 클래스(List와 비슷, 내부 배열 사용)를 상속하여, 만들어짐
  *  -> 내부 배열의 크기를 동적으로 조정할 수 있다.
  *
  * - 최근에는 Stack 대신 Deque를 상속 받은 ArrayDeque을 사용하도록 권장함.
  * */
  public static void main(String[] args) {

    /* Integer 타입을 저장하는 Stack 객체 생성 */

    Stack<Integer> stack = new Stack<>();

    System.out.println("===== 스택에 요소 추가 - push() ===== ");
    // add 는 부모인 Vector에서 제공하는 메서드. push를 사용할 것
    stack.push(1); // 스택 : [1]
    stack.push(2); // 스택 : [1, 2]
    stack.push(3); // 스택 : [1, 2, 3]
    System.out.println(stack);

    System.out.println("===== 최상단 요소 확인 - peek() =====");

    // stack이 비어있는 상태에서, peek(), pop() 수행 시
    // EmptyStackException이 발생하므로
    // 아래 처럼 if문 처리하거나, try, catch 문으로 예외처리 해야함.
    if( stack != null && !stack.isEmpty()){
      System.out.println("peak() 결과 :" + stack.peek());
      System.out.println("peak() 호출 후 결과 :" + stack); // 스택 : [1, 2, 3] (유지)
    }

    System.out.println("===== 스택에서 마지막 요소를 제거하는/뽑아내는 - pop() =====");
    System.out.printf("pop 결과 : %d / 현재 스택 : %s \n", stack.pop(), stack);
    System.out.printf("pop 결과 : %d / 현재 스택 : %s \n", stack.pop(), stack);
    System.out.printf("pop 결과 : %d / 현재 스택 : %s \n", stack.pop(), stack);

  }
}
