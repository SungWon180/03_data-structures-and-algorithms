package com.ohgiraffers.section07.heap;


import java.util.PriorityQueue;

/*
* 자바 컬렉션 중 Heap을 직접 지원하는 클래스는 없지만
* PriorityQueue 우선순위 큐
* -> 기본적으로 최소 힙으로 동작
*
* - 최소 힙 : 낮은 숫자가 높은 우선 순위를 갖는다.
* */
public class Application {
  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(10);
    minHeap.offer(5);
    System.out.println("현재 최소 힙 : " + minHeap);
    System.out.println("최소값 조회(peek()) : " + minHeap.peek()); // 선택해서 봄 (보기만 함)

    minHeap.offer(8);
    System.out.println("poll() 결과 : " + minHeap.poll()); // 하나씩 제거
    System.out.println("현재 최소 힙 : " + minHeap);

    System.out.println("poll() 결과 : " + minHeap.poll()); // 하나씩 제거
    System.out.println("현재 최소 힙 : " + minHeap);

    System.out.println("poll() 결과 : " + minHeap.poll()); // 하나씩 제거
    System.out.println("현재 최소 힙 : " + minHeap);

    // 최대 힙으로 하려면 정렬 기준을 바꾸면 된다.

    System.out.println("---------------------------------------------------------");

    /* 최대 힙 (Max Heap)
    * - PriorityQueue를 최대 힙으로 사용 하려면
    * 생성자 매개 변수로 Comparator를 전달하여          Comparator ==> 함수형 인터페이스 람다 넣기 가능 PriorityQueue<>(); 여기 안에 집어넣어야함
    * 요소의 우선 순위 결정 방식을 변경해야한다.!!!(내림차순)
    *
    * */

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b - a); //PriorityQueue<>((a,b)-> b - a) Comparator 안에 있는 추상 메서드 구현 가능

    maxHeap.offer(10);
    maxHeap.offer(5);
    maxHeap.offer(8);

    System.out.println("현재 최대 힙 : " + maxHeap);

    System.out.println("최대값 조회(peek()) : " + maxHeap.peek()); // 선택해서 봄 (보기만 함)

    System.out.println("poll() 결과 : " + maxHeap.poll()); // 하나씩 제거
    System.out.println("현재 최대 힙 : " + maxHeap);

    System.out.println("poll() 결과 : " + maxHeap.poll()); // 하나씩 제거
    System.out.println("현재 최대 힙 : " + maxHeap);

    System.out.println("poll() 결과 : " + maxHeap.poll()); // 하나씩 제거
    System.out.println("현재 최대 힙 : " + maxHeap);



  }
}
